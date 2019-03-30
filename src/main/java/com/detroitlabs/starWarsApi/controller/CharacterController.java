package com.detroitlabs.starWarsApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CharacterController {


    @RequestMapping("/")
    public String displayHomePage(){
        return "homepage";
    }

    @RequestMapping("/detailsPage")
    public String displayCharacterDetailsPage(){
        return "detailsPage";
    }
}
