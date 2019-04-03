package com.detroitlabs.starWarsApi.controller;

import com.detroitlabs.starWarsApi.Service.StarWarsService;
import com.detroitlabs.starWarsApi.data.EpisodeRepository;
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

        ResponseEntity<StarWarsCharacter> responseEntity = starWarsService.fetchCharacter("18");

        ResponseEntity<EpisodeData> episodeDataEntity = starWarsService.fetchEpisodeData();

        String characterHomeworldUri = responseEntity.getBody().getHomeworld();

        ResponseEntity<Planet> planetEntity = starWarsService.fetchCharacterPlanet(characterHomeworldUri);

        modelMap.put("body", episodeDataEntity.toString());
        modelMap.put("name", responseEntity.getBody().getName());
        modelMap.put("homeworld", planetEntity.getBody().getPlanetName());
       // modelMap.put("episodeTitle", episodeDataEntity.getBody().getEpisodeTitle());

        //modelMap.put("title", characters.toString());

        return "homepage";
    }

    @RequestMapping("/detailsPage/{characterId}")
    public String displayCharacterDetailsPage(@PathVariable(name="characterId") String characterId, ModelMap modelMap){

        ResponseEntity<StarWarsCharacter> responseEntity = starWarsService.fetchCharacter(characterId);

        modelMap.put("name", responseEntity.getBody().getName());
//        modelMap.put("birth_year", responseEntity.getBody().getBirth_year());

        return "detailsPage";
    }
}
