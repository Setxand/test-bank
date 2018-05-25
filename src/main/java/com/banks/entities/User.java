package com.banks.entities;

import com.banks.models.UserModel;
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
    @Column(unique = true)
    private String login;
    private String password;
    private String name;
    private String lastName;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Card>cards = new ArrayList<>();

    public User(UserModel userModel) {
        this.login = userModel.getLogin();
        this.password = userModel.getPassword();
        this.name = userModel.getName();
        this.lastName = userModel.getLastName();
    }

    public void addCard(Card card){
        cards.add(card);
        card.setUser(this);
    }
}
