package com.detroitlabs.starWarsApi.controller;

import com.detroitlabs.starWarsApi.Service.StarWarsService;
import com.detroitlabs.starWarsApi.model.StarWarsCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CharacterController {

    @Autowired
    private StarWarsService starWarsService;


    @RequestMapping("/")
    public String displayHomePage(ModelMap modelMap){

        ResponseEntity<StarWarsCharacter> responseEntity = starWarsService.fetchCharacter();

        modelMap.put("name", responseEntity.getBody().getName());

        return "homepage";
    }

    @RequestMapping("/detailsPage")
    public String displayCharacterDetailsPage(){
        return "detailsPage";
    }
}
