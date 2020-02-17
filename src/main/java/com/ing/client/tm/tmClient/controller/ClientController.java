package com.ing.client.tm.tmClient.controller;

import com.ing.client.tm.tmClient.entities.Transaction;
import com.ing.client.tm.tmClient.service.TransactionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin
@Controller
public class ClientController {


    @Autowired
    private TransactionData transactionData;


    @RequestMapping(value = "/client/tm",method = RequestMethod.GET)
    public ResponseEntity<Transaction[]> getTransaction(@RequestParam(value = "startDate")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime  startDate, @RequestParam(value = "endtDate")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime  endtDate, @RequestParam(value = "name", required=false) String name)
    {
        return ResponseEntity.accepted().body(transactionData.getTransactions(startDate, endtDate, name));
    }


    @RequestMapping(method = GET,value= {"/client/name"})
    public ResponseEntity<List<String>> getDistinctNameList(@RequestParam(value = "nameChar", required=false,defaultValue = "A") String name)
    {
        return ResponseEntity.accepted().body(transactionData.getNames(name));
    }


}