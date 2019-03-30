package com.detroitlabs.starWarsApi.Service;

import com.detroitlabs.starWarsApi.model.EpisodeData;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StarWarsService {

    public EpisodeData fetchEpidodeData(){
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://swapi.co/api/films/2", EpisodeData.class );
    }

}
