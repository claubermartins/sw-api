package com.swapapi.model;

import java.util.List;


public class PlanetResponse {
    private List<Planet> results;


    public PlanetResponse(List<Planet> results) {
        this.results = results;
    }

    public PlanetResponse() {

    }

    public List<Planet> getResults() {
        return results;
    }

    public void setResults(List<Planet> results) {
        this.results = results;
    }

}
