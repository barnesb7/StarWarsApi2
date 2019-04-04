package com.detroitlabs.starWarsApi.Service;

import com.detroitlabs.starWarsApi.data.EpisodeRepository;
import com.detroitlabs.starWarsApi.model.EpisodeData;
import com.detroitlabs.starWarsApi.model.Planet;
import com.detroitlabs.starWarsApi.model.StarWarsCharacter;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class StarWarsService {

    public ResponseEntity<StarWarsCharacter> fetchCharacter(String characterId) {

        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://swapi.co/api/people/" + characterId;
        HttpEntity<String> entity = createHttpEntity();

        return restTemplate.exchange(uri, HttpMethod.GET, entity, StarWarsCharacter.class);
    }

    public ResponseEntity<Planet> fetchCharacterPlanet(String planetUri) {

        RestTemplate restTemplate = new RestTemplate();
        String uri = planetUri;
        HttpEntity<String> entity = createHttpEntity();

        return restTemplate.exchange(uri, HttpMethod.GET, entity, Planet.class);
    }


    public ResponseEntity<EpisodeData> fetchEpisodeData() {

        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://swapi.co/api/films/2";
        HttpEntity<String> entity = createHttpEntity();

        return restTemplate.exchange(uri, HttpMethod.GET, entity, EpisodeData.class);
    }

    public HttpEntity<String> createHttpEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent","Brian");
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<String>("Hello World!", headers);
    }

}
