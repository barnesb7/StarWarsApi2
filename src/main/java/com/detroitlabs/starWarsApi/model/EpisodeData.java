package com.detroitlabs.starWarsApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeData {

    private String title;
    private List<String> characters = new ArrayList<>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("characters")
    public List<String> getCharacters() {
        return characters;
    }

    @JsonProperty("characters")
    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }
}
