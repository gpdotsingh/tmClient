package com.ing.client.tm.tmClient.controller;

import com.ing.client.tm.tmClient.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class HomeController {

    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;

    @RequestMapping(value = "/api/users",method = RequestMethod.GET)
    public ResponseEntity<Transaction[]> getTransaction(@RequestParam(value = "startDate") String startDate, @RequestParam(value = "endtDate") String endtDate, @RequestParam(value = "name", required=false) String name, @RequestParam(value = "size", defaultValue = "25",required=false) String size)
    {
        Transaction[]  userList=   oAuth2RestTemplate.getForEntity("http://localhost:8080/api/tm",
                Transaction[].class).getBody();
        return ResponseEntity.accepted().body(userList);
    }
}