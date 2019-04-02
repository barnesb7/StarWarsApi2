package com.detroitlabs.starWarsApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StarWarsCharacter {

    private String name;
    private String birth_year;
    private String hair_color;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("birth_year")
    public String getBirth_year() {
        return birth_year;
    }

    @JsonProperty("birth_year")
    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    @JsonProperty("hair_color")
    public String getHair_color() {
        return hair_color;
    }

    @JsonProperty("hair_color")
    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }
}
