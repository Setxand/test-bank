package com.banks.entities;

import lombok.Data;

@Data
public class ClientDTO {
    private String name;
    private String address;
    private String age;
    private Integer bankAccount;
}
