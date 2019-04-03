package com.detroitlabs.starWarsApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet {

    private String planetName;

    @JsonProperty("name")
    public String getPlanetName() {
        return planetName;
    }

    @JsonProperty("name")
    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }
}
