package com.banks.controllers;

import com.banks.entities.User;
import com.banks.services.reposiroryServices.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by TEST on 23.05.2018.
 */
@RestController
public class RequestHandler {
    @Autowired
    private UserRepositoryService userRepositoryService;

    @GetMapping("/loginAuth")
    public ModelAndView login(@RequestParam ("login")String login,@RequestParam("pass")String password){
        User user = userRepositoryService.findByLogin(login);
        if(user !=null)
        if(user.getPassword().equals(password) ){
            return new ModelAndView("welcomePage");
        }
        return new ModelAndView("noMuchLogAndPass");
    }
}
