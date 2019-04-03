package com.detroitlabs.starWarsApi.controller;

import com.detroitlabs.starWarsApi.Service.StarWarsService;
import com.detroitlabs.starWarsApi.model.EpisodeData;
import com.detroitlabs.starWarsApi.model.Planet;
import com.detroitlabs.starWarsApi.model.StarWarsCharacter;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CharacterController {

    @Autowired
    private StarWarsService starWarsService;


    @RequestMapping("/")
    public String displayHomePage(ModelMap modelMap){

        ResponseEntity<StarWarsCharacter> responseEntity = starWarsService.fetchCharacter("1");

        ResponseEntity<EpisodeData> episodeEntity = starWarsService.fetchEpisodeData();

        String characterHomeworldUri = responseEntity.getBody().getHomeworld();

        ResponseEntity<Planet> planetEntity = starWarsService.fetchCharacterPlanet(characterHomeworldUri);

        modelMap.put("name", responseEntity.getBody().getName());
        modelMap.put("homeworld", planetEntity.getBody().getPlanetName());

        //modelMap.put("title", characters.toString());

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
