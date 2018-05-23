package com.banks.controllers;

import com.banks.entities.Client;
import com.banks.services.reposiroryServices.CheckRepositoryService;
import com.banks.services.reposiroryServices.ClientRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @Autowired
    private ClientRepositoryService clientRepositoryService;

    @Autowired
    private CheckRepositoryService checkRepositoryService;

    @GetMapping("/clients")
    public String listClients(Model model){
        model.addAttribute("clientList",clientRepositoryService.findAll());
        return "clients";
    }

    @GetMapping("/clients/{id}")
    public String clients(Model model, @PathVariable long id){
        model.addAttribute("client", checkRepositoryService.findOne(id));
        return "clientInfo";
    }

    @PostMapping("/clientForm")
    public String newClient(@ModelAttribute("client") Client client){
        clientRepositoryService.saveAndFlush(client);
        return "redirect:clients";
    }
}
