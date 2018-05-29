package com.banks.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
@Entity
@Data
public class BankAccount {
    @Id
    @GeneratedValue
    private Long id;
    @ElementCollection
    @CollectionTable(
            name="amounts",
            joinColumns = @JoinColumn(name="id"))
    @Column(name="allAmount")
    private List<Integer> amount;

    public BankAccount() {
    }

}
