package com.ing.client.tm.tmClient.service;

import com.ing.client.tm.tmClient.entities.Transaction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionData {
    public Transaction[] getTransactions(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam("startDate") LocalDateTime startDate, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam("endtDate") LocalDateTime endtDate, @RequestParam(value = "name", required = false) String name) ;
    public List<String> getNames(@RequestParam(value = "nameChar", required = false, defaultValue = "A") String name) ;
}
