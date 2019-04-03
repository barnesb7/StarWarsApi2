package com.detroitlabs.starWarsApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeData {

    private String episodeTitle;
    private List<String> characters = new ArrayList<>();

    @JsonProperty("title")
    public String getEpisodeTitle() {
        return episodeTitle;
    }

    @JsonProperty("title")
    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
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
