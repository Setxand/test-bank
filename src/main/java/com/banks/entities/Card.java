package com.banks.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TEST on 24.05.2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String number;
    private String cvv;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "card")
    private List<Transaction>transactions = new ArrayList<>();

    public void addNewTransaction(Transaction transaction){
        transactions.add(transaction);
        transaction.setCard(this);
    }

}
