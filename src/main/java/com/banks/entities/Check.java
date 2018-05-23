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
public class Check {
    @Id
    @GeneratedValue
    private Long id;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
