package com.test;

import com.test.model.InformationSecurities;
import com.test.model.TradingHistory;
import com.test.repo.InformationSecuritiesRepo;
import com.test.repo.TradingHistoryRepo;
import com.test.xml.Data;
import com.test.xml.FileXML;
import com.test.xml.Row;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class Rest {

    private static final String HISTORY = "history";
    private static final String SECURITIES = "securities";


    private static String UPLOAD_DIR = System.getProperty("user.home") + "/test";

    @Autowired
    InformationSecuritiesRepo securitiesRepo;

    @Autowired
    TradingHistoryRepo tradingHistoryRepo;

    @GetMapping("/infosec/get")
    ResponseEntity<?> allInfo() {
        List<InformationSecurities> is = (List<InformationSecurities>) securitiesRepo.findAll();
        return new ResponseEntity<>(is, HttpStatus.OK);
    }

    @GetMapping("/trading/get")
    ResponseEntity<?> allTrade() {
        return new ResponseEntity<>(tradingHistoryRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/infosec/get/secid")
    ResponseEntity<?> getSecid() {
        List<InformationSecurities> securities = (List<InformationSecurities>) securitiesRepo.findAll();
        List<String> secids = securities.stream().map(InformationSecurities::getSecid).collect(Collectors.toList());
        return new ResponseEntity<>(secids, HttpStatus.OK);
    }

    @PutMapping("/infosec/update")
    ResponseEntity<?> updateInfo(@RequestBody InformationSecurities secure) {

        try {

            securitiesRepo.save(secure);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/trading/update")
    ResponseEntity<?> updateTrading(@RequestBody TradingHistory th) {

        InformationSecurities is = securitiesRepo.getInfoSecuryBySECID(th.getSECID());
        th.setIs(is);

        try {

            tradingHistoryRepo.save(th);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/infosec/create")
    ResponseEntity<?> create(@RequestBody InformationSecurities secure) {
        try {

            InformationSecurities is = securitiesRepo.save(secure);
            return new ResponseEntity<>(is, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {

            return new ResponseEntity<>(1, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/trading/create")
    ResponseEntity<?> createTrading(@RequestBody TradingHistory th) {
        try {

            InformationSecurities is = securitiesRepo.getInfoSecuryBySECID(th.getSECID());
            th.setIs(is);
            TradingHistory created_th = tradingHistoryRepo.save(th);
            return new ResponseEntity<>(created_th, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {

            return new ResponseEntity<>(1, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/infosec/delete/{id}")
    ResponseEntity<?> deleteSecure(@PathVariable Long id) {
        try {

            tradingHistoryRepo.deleteTradingsBySECID(securitiesRepo.findById(id).get().getSecid());
            securitiesRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/trading/delete/{id}")
    ResponseEntity<?> deleteTrading(@PathVariable Long id) {
        try {
            tradingHistoryRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/merge/table/get")
    @ResponseBody
    ResponseEntity<Object> get() {
        List<JSONObject> objectList = new ArrayList<>();
        try {

            for (InformationSecurities is : securitiesRepo.findAll()) {

                for (TradingHistory th : is.getTh()) {

                    JSONObject object = new JSONObject();

                    object.put("secid", is.getSecid());
                    object.put("regnumber", is.getRegnumber());
                    object.put("name", is.getName());
                    object.put("emitent_title", is.getEmitent_title());
                    object.put("tradedate", th.getTRADEDATE());
                    object.put("numtrades", th.getNUMTRADES());
                    object.put("open", th.getOPEN());
                    object.put("close", th.getCLOSE());

                    objectList.add(object);
                }
            }

            System.err.println(objectList);
            return new ResponseEntity<>(objectList.toString(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/rest/uploadMultiFiles")
    public ResponseEntity<?> uploadFileMulti(@ModelAttribute UploadForm form) throws Exception {

        String result;
        try {
            result = this.saveUploadedFiles(form.getFiles());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        if (result.isEmpty())
            return new ResponseEntity<>("Данные добавлены",HttpStatus.OK);
        else return new ResponseEntity<>("Произошла ошибка при загрузке данных\nСкорее всего не все данные удалось загрузить",HttpStatus.OK);
    }

    private String saveUploadedFiles(MultipartFile[] files) throws IOException, JAXBException {


        File uploadDir = new File(UPLOAD_DIR);
        uploadDir.mkdirs();

        StringBuilder sb = new StringBuilder();

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue;
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(Objects.requireNonNull(file.getOriginalFilename()));
            Files.write(path, bytes);

            File file1 = new File(String.valueOf(path));

            JAXBContext jc = JAXBContext.newInstance(FileXML.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();

            FileXML tests = (FileXML) unmarshaller.unmarshal(file1);

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(tests, System.err);

            file1.deleteOnExit();

            for (Data d : tests.getData())
                if (d.getId().equals(HISTORY)) {

                    Row[] rows = d.getRows().getRow();
                    ArrayList<InformationSecurities> securities = (ArrayList<InformationSecurities>) securitiesRepo.findAll();

                    for (InformationSecurities sec : securities) {

                        for (Row row : rows) {

                            if (row.getSECID().equals(sec.getSecid())) {

                                TradingHistory th = new TradingHistory(row, sec);
                                sec.setTh(th);
                                try {
                                    securitiesRepo.save(sec);
                                } catch (Exception e) {
                                    sb.append(e.getMessage());
                                }

                                break;
                            }
                        }
                    }
                } else if (d.getId().equals(SECURITIES)) {

                    Row[] rows = d.getRows().getRow();

                    for (Row row : rows) {
                        try {
                            securitiesRepo.save(new InformationSecurities(row));
                        } catch (Exception e) {
                            System.err.println("ERR: " + e.getMessage());
                           // sb.append(e.getMessage());
                        }
                    }
                }

        }
        return sb.toString();
    }


}
