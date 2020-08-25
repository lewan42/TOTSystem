package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.xml.Row;
import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
@Entity
@Table(name = "tradingHistory")
public class TradingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "_BOARDID")
    private String BOARDID;

    @Column(name = "_TRADEDATE")
    private String TRADEDATE;

    @Column(name = "_SHORTNAME")
    private String SHORTNAME;

    @Column(name = "_SECID")
    private String SECID;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "is_id", nullable = false)
    private InformationSecurities is;

    @Column(name = "_NUMTRADES")
    private String NUMTRADES;

    @Column(name = "_VALUE")
    private String VALUE;

    @Column(name = "_OPEN")
    private String OPEN;

    @Column(name = "_LOW")
    private String LOW;

    @Column(name = "_HIGH")
    private String HIGH;

    @Column(name = "_LEGALCLOSEPRICE")
    private String LEGALCLOSEPRICE;

    @Column(name = "_WAPRICE")
    private String WAPRICE;

    @Column(name = "_CLOSE")
    private String CLOSE;

    @Column(name = "_VOLUME")
    private String VOLUME;

    @Column(name = "_MARKETPRICE2")
    private String MARKETPRICE2;

    @Column(name = "_MARKETPRICE3")
    private String MARKETPRICE3;

    @Column(name = "_ADMITTEDQUOTE")
    private String ADMITTEDQUOTE;

    @Column(name = "_MP2VALTRD")
    private String MP2VALTRD;

    @Column(name = "_MARKETPRICE3TRADESVALUE")
    private String MARKETPRICE3TRADESVALUE;

    @Column(name = "_ADMITTEDVALUE")
    private String ADMITTEDVALUE;

    @Column(name = "_WAVAL")
    private String WAVAL;

    public TradingHistory() {
    }

    public TradingHistory(Row th, InformationSecurities is) {
        this.id = 0L;
        this.BOARDID = th.getBOARDID();
        this.is = is;
        // this.TRADEDATE = (Date) DateTimeFormatter.ofPattern("yyyy-MM-d").parse(th.getTRADEDATE());
        this.TRADEDATE = th.getTRADEDATE();
        this.SHORTNAME = th.getSHORTNAME();
        this.SECID = th.getSECID();
        this.NUMTRADES = th.getNUMTRADES();
        this.VALUE = th.getVALUE();
        this.OPEN = th.getOPEN();
        this.LOW = th.getLOW();
        this.HIGH = th.getHIGH();
        this.LEGALCLOSEPRICE = th.getLEGALCLOSEPRICE();
        this.WAPRICE = th.getWAPRICE();
        this.CLOSE = th.getCLOSE();
        this.VOLUME = th.getVOLUME();
        this.MARKETPRICE2 = th.getMARKETPRICE2();
        this.MARKETPRICE3 = th.getMARKETPRICE3();
        this.ADMITTEDQUOTE = th.getADMITTEDQUOTE();
        this.MP2VALTRD = th.getMP2VALTRD();
        this.MARKETPRICE3TRADESVALUE = th.getMARKETPRICE3TRADESVALUE();
        this.ADMITTEDVALUE = th.getADMITTEDVALUE();
        this.WAVAL = th.getWAVAL();
    }

    public TradingHistory(Long id, String BOARDID, String TRADEDATE, String SHORTNAME, String SECID, InformationSecurities informationSecurities, String NUMTRADES, String VALUE, String OPEN, String LOW, String HIGH, String LEGALCLOSEPRICE, String WAPRICE, String CLOSE, String VOLUME, String MARKETPRICE2, String MARKETPRICE3, String ADMITTEDQUOTE, String MP2VALTRD, String MARKETPRICE3TRADESVALUE, String ADMITTEDVALUE, String WAVAL) {
        this.id = id;
        this.BOARDID = BOARDID;
        this.TRADEDATE = TRADEDATE;
        this.SHORTNAME = SHORTNAME;
        this.SECID = SECID;
        this.is = informationSecurities;
        this.NUMTRADES = NUMTRADES;
        this.VALUE = VALUE;
        this.OPEN = OPEN;
        this.LOW = LOW;
        this.HIGH = HIGH;
        this.LEGALCLOSEPRICE = LEGALCLOSEPRICE;
        this.WAPRICE = WAPRICE;
        this.CLOSE = CLOSE;
        this.VOLUME = VOLUME;
        this.MARKETPRICE2 = MARKETPRICE2;
        this.MARKETPRICE3 = MARKETPRICE3;
        this.ADMITTEDQUOTE = ADMITTEDQUOTE;
        this.MP2VALTRD = MP2VALTRD;
        this.MARKETPRICE3TRADESVALUE = MARKETPRICE3TRADESVALUE;
        this.ADMITTEDVALUE = ADMITTEDVALUE;
        this.WAVAL = WAVAL;
    }

    public TradingHistory(Long id, String BOARDID, String TRADEDATE, String SHORTNAME, String SECID, String NUMTRADES, String VALUE, String OPEN, String LOW, String HIGH, String LEGALCLOSEPRICE, String WAPRICE, String CLOSE, String VOLUME, String MARKETPRICE2, String MARKETPRICE3, String ADMITTEDQUOTE, String MP2VALTRD, String MARKETPRICE3TRADESVALUE, String ADMITTEDVALUE, String WAVAL) {
        this.id = id;
        this.BOARDID = BOARDID;
        this.TRADEDATE = TRADEDATE;
        this.SHORTNAME = SHORTNAME;
        this.SECID = SECID;
        this.NUMTRADES = NUMTRADES;
        this.VALUE = VALUE;
        this.OPEN = OPEN;
        this.LOW = LOW;
        this.HIGH = HIGH;
        this.LEGALCLOSEPRICE = LEGALCLOSEPRICE;
        this.WAPRICE = WAPRICE;
        this.CLOSE = CLOSE;
        this.VOLUME = VOLUME;
        this.MARKETPRICE2 = MARKETPRICE2;
        this.MARKETPRICE3 = MARKETPRICE3;
        this.ADMITTEDQUOTE = ADMITTEDQUOTE;
        this.MP2VALTRD = MP2VALTRD;
        this.MARKETPRICE3TRADESVALUE = MARKETPRICE3TRADESVALUE;
        this.ADMITTEDVALUE = ADMITTEDVALUE;
        this.WAVAL = WAVAL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBOARDID() {
        return BOARDID;
    }

    public void setBOARDID(String BOARDID) {
        this.BOARDID = BOARDID;
    }

    public String getTRADEDATE() {
        return TRADEDATE;
    }

    public void setTRADEDATE(String TRADEDATE) {
        this.TRADEDATE = TRADEDATE;
    }

    public String getSHORTNAME() {
        return SHORTNAME;
    }

    public void setSHORTNAME(String SHORTNAME) {
        this.SHORTNAME = SHORTNAME;
    }

    public String getSECID() {
        return SECID;
    }

    public void setSECID(String SECID) {
        this.SECID = SECID;
    }

    public String getNUMTRADES() {
        return NUMTRADES;
    }

    public void setNUMTRADES(String NUMTRADES) {
        this.NUMTRADES = NUMTRADES;
    }

    public String getVALUE() {
        return VALUE;
    }

    public void setVALUE(String VALUE) {
        this.VALUE = VALUE;
    }

    public String getOPEN() {
        return OPEN;
    }

    public void setOPEN(String OPEN) {
        this.OPEN = OPEN;
    }

    public String getLOW() {
        return LOW;
    }

    public void setLOW(String LOW) {
        this.LOW = LOW;
    }

    public String getHIGH() {
        return HIGH;
    }

    public void setHIGH(String HIGH) {
        this.HIGH = HIGH;
    }

    public String getLEGALCLOSEPRICE() {
        return LEGALCLOSEPRICE;
    }

    public void setLEGALCLOSEPRICE(String LEGALCLOSEPRICE) {
        this.LEGALCLOSEPRICE = LEGALCLOSEPRICE;
    }

    public String getWAPRICE() {
        return WAPRICE;
    }

    public void setWAPRICE(String WAPRICE) {
        this.WAPRICE = WAPRICE;
    }

    public String getCLOSE() {
        return CLOSE;
    }

    public void setCLOSE(String CLOSE) {
        this.CLOSE = CLOSE;
    }

    public String getVOLUME() {
        return VOLUME;
    }

    public void setVOLUME(String VOLUME) {
        this.VOLUME = VOLUME;
    }

    public String getMARKETPRICE2() {
        return MARKETPRICE2;
    }

    public void setMARKETPRICE2(String MARKETPRICE2) {
        this.MARKETPRICE2 = MARKETPRICE2;
    }

    public String getMARKETPRICE3() {
        return MARKETPRICE3;
    }

    public void setMARKETPRICE3(String MARKETPRICE3) {
        this.MARKETPRICE3 = MARKETPRICE3;
    }

    public String getADMITTEDQUOTE() {
        return ADMITTEDQUOTE;
    }

    public void setADMITTEDQUOTE(String ADMITTEDQUOTE) {
        this.ADMITTEDQUOTE = ADMITTEDQUOTE;
    }

    public String getMP2VALTRD() {
        return MP2VALTRD;
    }

    public void setMP2VALTRD(String MP2VALTRD) {
        this.MP2VALTRD = MP2VALTRD;
    }

    public String getMARKETPRICE3TRADESVALUE() {
        return MARKETPRICE3TRADESVALUE;
    }

    public void setMARKETPRICE3TRADESVALUE(String MARKETPRICE3TRADESVALUE) {
        this.MARKETPRICE3TRADESVALUE = MARKETPRICE3TRADESVALUE;
    }

    public String getADMITTEDVALUE() {
        return ADMITTEDVALUE;
    }

    public void setADMITTEDVALUE(String ADMITTEDVALUE) {
        this.ADMITTEDVALUE = ADMITTEDVALUE;
    }

    public String getWAVAL() {
        return WAVAL;
    }

    public void setWAVAL(String WAVAL) {
        this.WAVAL = WAVAL;
    }

    public InformationSecurities getIs() {
        return is;
    }

    public void setIs(InformationSecurities is) {
        this.is = is;
    }

    @Override
    public String toString() {
        return "TradingHistory{" +
                "id=" + id +
                ", BOARDID='" + BOARDID + '\'' +
                ", TRADEDATE='" + TRADEDATE + '\'' +
                ", SHORTNAME='" + SHORTNAME + '\'' +
                ", SECID='" + SECID + '\'' +
//                ", informationSecurities=" + is +
                ", NUMTRADES='" + NUMTRADES + '\'' +
                ", VALUE='" + VALUE + '\'' +
                ", OPEN='" + OPEN + '\'' +
                ", LOW='" + LOW + '\'' +
                ", HIGH='" + HIGH + '\'' +
                ", LEGALCLOSEPRICE='" + LEGALCLOSEPRICE + '\'' +
                ", WAPRICE='" + WAPRICE + '\'' +
                ", CLOSE='" + CLOSE + '\'' +
                ", VOLUME='" + VOLUME + '\'' +
                ", MARKETPRICE2='" + MARKETPRICE2 + '\'' +
                ", MARKETPRICE3='" + MARKETPRICE3 + '\'' +
                ", ADMITTEDQUOTE='" + ADMITTEDQUOTE + '\'' +
                ", MP2VALTRD='" + MP2VALTRD + '\'' +
                ", MARKETPRICE3TRADESVALUE='" + MARKETPRICE3TRADESVALUE + '\'' +
                ", ADMITTEDVALUE='" + ADMITTEDVALUE + '\'' +
                ", WAVAL='" + WAVAL + '\'' +
                '}';
    }
}
