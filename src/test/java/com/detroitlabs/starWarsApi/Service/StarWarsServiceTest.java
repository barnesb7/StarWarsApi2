package com.detroitlabs.starWarsApi.Service;

import com.detroitlabs.starWarsApi.model.EpisodeData;
import com.detroitlabs.starWarsApi.model.StarWarsCharacter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StarWarsServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private StarWarsService starWarsService = new StarWarsService();

    @Test
    public void shouldReturnACharacterResponseEntity(){

        Mockito
       .when(restTemplate.getForEntity("https://swapi.co/api/people/1" , StarWarsCharacter.class))
          .thenReturn(new ResponseEntity("endpoint hit", HttpStatus.OK));

        ResponseEntity<StarWarsCharacter> actualResponseEntity = starWarsService.fetchCharacter("1");

        assertEquals("Luke Skywalker", actualResponseEntity.getBody().getName());
        assertEquals("male", actualResponseEntity.getBody().getGender());
        assertEquals(200, actualResponseEntity.getStatusCodeValue());

    }

    @Test
    public void shouldHave200StatusWhenGettingEpisodeData(){

        Mockito
                .when(restTemplate.getForEntity("https://swapi.co/api/films" , EpisodeData.class))
                .thenReturn(new ResponseEntity("endpoint hit", HttpStatus.OK));

        ResponseEntity<EpisodeData> actualResponseEntity = starWarsService.fetchEpisodeData();

        assertEquals("The Empire Strikes Back", actualResponseEntity.getBody().getEpisodeTitle());
        assertEquals(200, actualResponseEntity.getStatusCodeValue());

    }



}