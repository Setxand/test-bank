package com.banks.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by TEST on 23.05.2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
    private String sender;
    private String receiver;
    private Integer amount;
    private String date;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;


}
