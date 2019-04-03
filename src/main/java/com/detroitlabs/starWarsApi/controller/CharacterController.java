package com.detroitlabs.starWarsApi.controller;

import com.detroitlabs.starWarsApi.Service.StarWarsService;
import com.detroitlabs.starWarsApi.model.EpisodeData;
import com.detroitlabs.starWarsApi.model.StarWarsCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CharacterController {

    @Autowired
    private StarWarsService starWarsService;


    @RequestMapping("/")
    public String displayHomePage(ModelMap modelMap){

        ResponseEntity<StarWarsCharacter> responseEntity = starWarsService.fetchCharacter("1");

//        ResponseEntity<EpisodeData> episodeEntity = starWarsService.fetchEpisodeData();

        modelMap.put("name", responseEntity.getBody().getName());
//        modelMap.put("title", episodeEntity.getBody().getTitle());

        return "homepage";
    }

    @RequestMapping("/detailsPage")
    public String displayCharacterDetailsPage(ModelMap modelMap){

        ResponseEntity<StarWarsCharacter> responseEntity = starWarsService.fetchCharacter("1");

        modelMap.put("name", responseEntity.getBody().getName());
//        modelMap.put("birth_year", responseEntity.getBody().getBirth_year());

        return "detailsPage";
    }
}
