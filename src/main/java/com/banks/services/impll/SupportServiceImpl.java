package com.banks.services.impll;

import com.banks.entities.Card;
import com.banks.entities.Transaction;
import com.banks.entities.User;
import com.banks.models.UserModel;
import com.banks.services.SupportService;
import com.banks.services.reposiroryServices.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by TEST on 25.05.2018.
 */
@Service
public class SupportServiceImpl implements SupportService {
    @Autowired
    private UserRepositoryService userRepositoryService;
    @Override
    public boolean clientRegister(UserModel userModel) {
        User user = userRepositoryService.findByLogin(userModel.getLogin());
        if(user==null){
           return userSaving(userModel,user);
        }

        return false;
    }

    private boolean userSaving(UserModel userModel, User user) {
        try {


            user = new User(userModel);
            Card card = new Card();
            Random rand = new Random();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                int number = rand.nextInt(9999) + 1;
                stringBuilder.append(number + " ");
            }
            card.setNumber(stringBuilder.toString());
            card.setAmount(100);
            Integer cvv = rand.nextInt(999) + 1;
            card.setCvv((cvv.toString()));
            user.addCard(card);
            Transaction transaction = new Transaction();
            transaction.setAmount(100);
            transaction.setDate(new java.util.Date().toString());
            transaction.setReceiver(user.getLogin());
            transaction.setSender("Test bank");
            card.addNewTransaction(transaction);
            userRepositoryService.saveAndFlush(user);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
