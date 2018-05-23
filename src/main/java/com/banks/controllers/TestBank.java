package com.banks.controllers;

import com.banks.entities.Transaction;
import com.banks.services.reposiroryServices.TransactionRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
@Controller
public class TestBank {
    @Autowired
    private TransactionRepositoryService transactionRepositoryService;

    @GetMapping("/searchByName")
    public String searchByName(@RequestParam("name") String name,Model model){
        StringBuilder modName = new StringBuilder(name);
        modName.setCharAt(0,Character.toUpperCase(modName.charAt(0)));

        List<Transaction>transactions = transactionRepositoryService.findByName(modName.toString());
        model.addAttribute("transactions",transactions);
        return "transactions";
    }

    @RequestMapping(name = "/transactions" ,method = RequestMethod.GET)
    public String transactions(Model  model){
        List<Transaction>transactions = transactionRepositoryService.findAll();
        model.addAttribute("transactions",transactions);
        return "transactions";
    }
}
