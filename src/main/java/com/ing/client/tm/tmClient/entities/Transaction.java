package com.ing.client.tm.tmClient.entities;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Transaction
{
    private  int id;
    private String name;
    private String email;
    private String transactioId;
    private LocalDateTime transactionTime;
    private boolean verifiedUser;

    //Setters and getters

    @Override
    public String toString() {
        return "UserProfile [name=" + name + ", email=" + email + "]";
    }
}