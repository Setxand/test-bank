package com.banks.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String age;
    @ManyToOne
    @JoinColumn(name = "id_bank")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private BankAccount bankAccount;

    private Integer sum;
}
