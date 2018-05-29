package com.banks.controllers;

import com.banks.entities.AmountDTO;
import com.banks.entities.BankAccount;
import com.banks.entities.Client;
import com.banks.entities.SumDTO;
import com.banks.services.reposiroryServices.CheckRepositoryService;
import com.banks.services.reposiroryServices.ClientRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientController {

    //List<Client> clients = new ArrayList<>(100);
    private Long id;

    @Autowired
    private ClientRepositoryService clientRepositoryService;

    @Autowired
    private CheckRepositoryService checkRepositoryService;

    @GetMapping("/clients")
    public String listClients(Model model){
        System.out.println(checkRepositoryService.allSumAccount(3L));
        for (Client client: clientRepositoryService.findAll()
             ) {
            System.out.println(client);
            client.setSum(checkRepositoryService.allSumAccount(client.getId()));
            System.out.println(client);
            if (client.getSum().equals(null))
                client.setSum(0);
            System.out.println(client);
            clientRepositoryService.saveAndFlush(client);
        }
        model.addAttribute("clientList", clientRepositoryService.findAll());
        return "clients";
    }

    @GetMapping("/clients/{id}")
    public String clients(Model model, @PathVariable long id){
        model.addAttribute("client", checkRepositoryService.getBankAccount(id));
        model.addAttribute("amount", new AmountDTO());
        this.id = id;
        return "clientInfo";
    }

    @PostMapping("/amountForm")
    public String newAccount(@ModelAttribute(value="amount") AmountDTO integer, Model model){
        System.out.println(integer.getAm());
        BankAccount bankAccount1 = checkRepositoryService.getOneBankAccount(this.id);
        System.out.println(bankAccount1);
        bankAccount1.getAmount().add(integer.getAm());
        System.out.println(bankAccount1);
        checkRepositoryService.saveAndFlush(bankAccount1);
        System.out.println(bankAccount1);
        return "redirect:clients";
    }

    @GetMapping("/formClient")
    public String newClient(Model model){
        model.addAttribute("client", new Client());
        return "formClient";
    }

    @PostMapping("/clientForm")
    public String newClient(@ModelAttribute(value="сlient") Client client, Model model){
        System.out.println(client);
        clientRepositoryService.saveAndFlush(client);
        return "redirect:clients";
    }
}
