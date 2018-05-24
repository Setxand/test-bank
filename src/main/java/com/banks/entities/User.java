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
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String name;
    private String lastName;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Card>cards;
}
