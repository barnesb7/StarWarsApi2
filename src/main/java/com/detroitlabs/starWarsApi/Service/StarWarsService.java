package com.detroitlabs.starWarsApi.Service;

import com.detroitlabs.starWarsApi.model.EpisodeData;
import com.detroitlabs.starWarsApi.model.Planet;
import com.detroitlabs.starWarsApi.model.StarWarsCharacter;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Component
public class StarWarsService {

    public ResponseEntity<StarWarsCharacter> fetchCharacter(String characterId) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://swapi.co/api/people/1";

         HttpEntity<String> entity = setDefaultHeaderInformation();

        ResponseEntity<StarWarsCharacter> characterEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, StarWarsCharacter.class);

        return characterEntity;
    }

    public ResponseEntity<Planet> fetchCharacterPlanet(String planetUri) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = planetUri;

        HttpEntity<String> entity = setDefaultHeaderInformation();

        ResponseEntity<Planet> planetEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, Planet.class);

        return planetEntity;
    }


    public ResponseEntity<EpisodeData> fetchEpisodeData() {

        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://swapi.co/api/films/2";

        HttpEntity<String> entity = setDefaultHeaderInformation();

        ResponseEntity<EpisodeData> episodeEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, EpisodeData.class);

        return episodeEntity;

    }

    public HttpEntity<String> setDefaultHeaderInformation(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent","Brian");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("Hello World!", headers);
        return entity;
    }

}
