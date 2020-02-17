package com.ing.client.tm.tmClient.service;


import com.ing.client.tm.tmClient.common.AppConfig;
import com.ing.client.tm.tmClient.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionDataImpl implements  TransactionData{

    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;
    @Autowired
    AppConfig appConfig;
    public Transaction[] getTransactions(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam("startDate") LocalDateTime startDate, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam("endtDate") LocalDateTime endtDate, @RequestParam(value = "name", required = false) String name) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(appConfig.getRootUrl());
        uriBuilder.queryParam("startDate",startDate);
        uriBuilder.queryParam("endtDate",endtDate);
        uriBuilder.queryParam("name",name);

        return oAuth2RestTemplate.getForEntity(uriBuilder.build().toString(),
                Transaction[].class).getBody();
    }


    public List<String> getNames(@RequestParam(value = "nameChar", required = false, defaultValue = "A") String name) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(appConfig.getNameUrl());
        uriBuilder.queryParam("nameChar",name);
        return oAuth2RestTemplate.getForEntity(uriBuilder.build().toString(),
                ArrayList.class).getBody();
    }
}
