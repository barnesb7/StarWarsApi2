package com.detroitlabs.starWarsApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeData {

    private String title;
    private ArrayList<String> characterUrls;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("characters")
    public ArrayList<String> getCharacterUrls() {
        return characterUrls;
    }

    @JsonProperty("characters")
    public void setCharacterUrls(ArrayList<String> characterUrls) {
        this.characterUrls = characterUrls;
    }
}
