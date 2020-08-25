package com.test.repo;

import com.test.model.TradingHistory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface TradingHistoryRepo extends CrudRepository<TradingHistory, Long> {

    @Transactional
    @Modifying
    @Query("DELETE from TradingHistory t where t.SECID = ?1")
    void deleteTradingsBySECID(String secid);

}
