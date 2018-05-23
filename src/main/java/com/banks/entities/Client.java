package com.banks.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String age;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<BankAccount> bankAccounts = new ArrayList<>();

}
