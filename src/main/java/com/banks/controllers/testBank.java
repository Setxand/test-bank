package com.banks.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by TEST on 23.05.2018.
 */
@RestController
@RequestMapping("/bankTest")
public class testBank {

    @RequestMapping(name = "/login" )
    ModelAndView login(ModelAndView modelAndView){

        return new ModelAndView("");
    }
}
