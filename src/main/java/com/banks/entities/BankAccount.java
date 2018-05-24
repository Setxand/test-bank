package com.banks.entities;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;

/**
 * Created by TEST on 23.05.2018.
 */
@Entity
@Data
public class BankAccount {
    @Id
    @GeneratedValue
    private Long id;
    private Integer amount;
    @OneToOne
    @JoinColumn(name = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Transaction transaction;

    private String login;
    private String password;

    public BankAccount() {
    }

    public BankAccount(Integer amount) {
        this.amount = amount;
    }

}
