package com.banks.controllers;

import com.banks.entities.Card;
import com.banks.entities.Transaction;
import com.banks.entities.User;
import com.banks.models.UserModel;
import com.banks.services.SupportService;
import com.banks.services.reposiroryServices.CardRepositoryService;
import com.banks.services.reposiroryServices.TransactionRepositoryService;
import com.banks.services.reposiroryServices.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
@RestController
public class RequestHandlerController {
    @Autowired
    private UserRepositoryService userRepositoryService;
    @Autowired
    private TransactionRepositoryService transactionRepositoryService;
    @Autowired
    private CardRepositoryService cardRepositoryService;
    @Autowired
    private SupportService supportService;
    @GetMapping("/loginAuth")
    public ModelAndView login(@RequestParam ("login")String login,@RequestParam("pass")String password){
        User user = userRepositoryService.findByLogin(login);
        if(user !=null)
        if(user.getPassword().equals(password) ){
            return new ModelAndView("welcomePage");
        }
        return new ModelAndView("noMuchLogAndPass");
    }

    @GetMapping("/searchByRealName")
    public ModelAndView searchByRealName(@RequestParam("name")String name){
        List<User> users= userRepositoryService.findByName(name);
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @GetMapping("/cardDefinition")
    public ModelAndView cardDefinition(@RequestParam("id")Long id){
        Card card = cardRepositoryService.findOne(id);
        List<Transaction>transactions = card.getTransactions();
        ModelAndView modelAndView = new ModelAndView("transactions");
        modelAndView.addObject("transactions",transactions);
        return modelAndView;
    }

    @GetMapping("/searchByTransaction")
    public ModelAndView searchByTransaction(@RequestParam("name")String name){
        List<Transaction>transactions = transactionRepositoryService.findByName(name);
        ModelAndView modelAndView = new ModelAndView("transactions");
        modelAndView.addObject("transactions",transactions);
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.POST,value = "/userRegister")
    public boolean registerClient(@RequestBody UserModel user){
        return supportService.clientRegister(user);
    }


}
