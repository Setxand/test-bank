package com.banks.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "client_id")
    private Client client;
}
