package com.ing.client.tm.tmClient.controller;

import com.ing.client.tm.tmClient.entities.Transaction;
import com.ing.client.tm.tmClient.entities.UserNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin
@Controller
public class HomeController {

    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;

    @RequestMapping(value = "/client/tm",method = RequestMethod.GET)
    public ResponseEntity<Transaction[]> getTransaction(@RequestParam(value = "startDate")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime  startDate, @RequestParam(value = "endtDate")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime  endtDate, @RequestParam(value = "name", required=false) String name)
    {
        String url = "http://localhost:8080/api/tm";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url);
        uriBuilder.queryParam("startDate",startDate);
        uriBuilder.queryParam("endtDate",endtDate);
        uriBuilder.queryParam("name",name);

        Transaction[]  userList=   oAuth2RestTemplate.getForEntity(uriBuilder.build().toString(),
                Transaction[].class).getBody();
        return ResponseEntity.accepted().body(userList);
    }

    @RequestMapping(method = GET,value= {"/client/name"})
    public ResponseEntity<List<String>> getDistinctNameList(@RequestParam(value = "nameChar", required=false,defaultValue = "A") String name)
    {
        String url = "http://localhost:8080/api/name";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url);
        uriBuilder.queryParam("nameChar",name);
        List<String> names=   oAuth2RestTemplate.getForEntity(uriBuilder.build().toString(),
                ArrayList.class).getBody();
        return ResponseEntity.accepted().body(names);
    }
}