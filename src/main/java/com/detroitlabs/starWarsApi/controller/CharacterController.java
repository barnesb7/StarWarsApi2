package com.detroitlabs.starWarsApi.controller;

import com.detroitlabs.starWarsApi.Service.StarWarsService;
import com.detroitlabs.starWarsApi.model.EpisodeData;
import com.detroitlabs.starWarsApi.model.Planet;
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

        return "homepage";
    }

    @RequestMapping("/detailsPage/{characterId}")
    public String displayCharacterDetailsPage(@PathVariable(name="characterId") String characterId, ModelMap modelMap){

        ResponseEntity<StarWarsCharacter> responseEntity = starWarsService.fetchCharacter(characterId);

        ResponseEntity<EpisodeData> episodeDataEntity = starWarsService.fetchEpisodeData();

        String characterHomeworldUri = responseEntity.getBody().getHomeworld();

        ResponseEntity<Planet> planetEntity = starWarsService.fetchCharacterPlanet(characterHomeworldUri);

        modelMap.put("name", responseEntity.getBody().getName());
        modelMap.put("birthYear", responseEntity.getBody().getBirthYear());
        modelMap.put("gender", responseEntity.getBody().getGender());
        modelMap.put("homeworld", planetEntity.getBody().getPlanetName());

        return "detailsPage";
    }
}
