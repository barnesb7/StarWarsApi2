package com.detroitlabs.starWarsApi.Service;

import com.detroitlabs.starWarsApi.model.EpisodeData;
import com.detroitlabs.starWarsApi.model.StarWarsCharacter;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Component
public class StarWarsService {

    public ResponseEntity<StarWarsCharacter> fetchCharacter() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://swapi.co/api/people/1";
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent","Brian");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("Hello World!", headers);
        ResponseEntity<StarWarsCharacter> characterEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, StarWarsCharacter.class);

        return characterEntity;
    }


//    public ResponseEntity<StarWarsCharacter> fetchCharacter(){
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("host", "localhost:8080");
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("user-agent", "BB");
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        return restTemplate.exchange("https://swapi.co/api/people/1/", HttpMethod.GET, entity,  StarWarsCharacter.class);
// }

//
//    public EpisodeData fetchEpisodeData() {
//
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//
//             ResponseEntity<EpisodeData> episodeDataResponse = restTemplate.exchange("http://swapi.co/api/films/2", HttpMethod.GET,entity,EpisodeData.class);
//
//             return episodeDataResponse.getBody();



//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//
//        restTemplate.exchange("https://swapi.co/api/films/2", HttpMethod.POST, entity, EpisodeData.class);



        //RestTemplate restTemplate = new RestTemplate();
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("User-Agent", "wookie");
        //return restTemplate.getForObject("https://swapi.co/api/films/2", EpisodeData.class);
//    }
}
