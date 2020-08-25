package com.test.repo;

import com.test.model.InformationSecurities;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InformationSecuritiesRepo extends CrudRepository<InformationSecurities, Long> {


    @Query("SELECT s FROM InformationSecurities s WHERE s.secid = ?1")
    InformationSecurities getInfoSecuryBySECID(String secid);

}
