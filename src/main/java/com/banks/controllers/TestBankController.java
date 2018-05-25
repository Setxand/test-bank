package com.banks.controllers;

import com.banks.entities.Card;
import com.banks.entities.Transaction;
import com.banks.entities.User;
import com.banks.services.reposiroryServices.UserRepositoryService;
import com.banks.services.reposiroryServices.TransactionRepositoryService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
@Controller
public class TestBankController {
    @Autowired
    private TransactionRepositoryService transactionRepositoryService;
    @Autowired
    private UserRepositoryService userRepositoryService;
    @GetMapping("/searchByName")
    public String searchByName(@RequestParam("name") String name,Model model){
        StringBuilder modName = new StringBuilder(name);
        modName.setCharAt(0,Character.toUpperCase(modName.charAt(0)));
        User user = userRepositoryService.findByLogin(name);
        List<Card>cards = user.getCards();
        model.addAttribute("cards",cards);
        return "cards";
    }

    @RequestMapping(name = "/transactions" ,method = RequestMethod.GET)
    public String transactions(Model  model){
        List<Transaction>transactions = transactionRepositoryService.findAll();
        model.addAttribute("transactions",transactions);
        return "transactions";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/welcomePage")
    public String welcome(){
        return "welcomePage";
    }




    @GetMapping("/users")
    public String users(Model model){
        List<User>users = userRepositoryService.findAll();
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("/cards")
    public String cards(){
        return "cards";
    }

    @GetMapping("/successRegister")
    public String successReg(){
        return "successRegister";
    }

    @GetMapping("/errorRegister")
    public String errorRegister(){
        return "errorRegister";
    }


}
