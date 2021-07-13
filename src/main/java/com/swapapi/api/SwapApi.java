package com.swapapi.api;

import com.swapapi.model.PlanetResponse;
import com.swapapi.model.Planet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.List;

public class SwapApi {
    public List<Planet> obterTodos() {
        RestTemplate restTemplate = new RestTemplate();
        String urlBase = "https://swapi.dev/api/planets/";

        HttpHeaders header = new HttpHeaders();
        header.set("ContentType", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(header);

        ResponseEntity<PlanetResponse> planets = restTemplate.exchange(urlBase, HttpMethod.GET, entity, PlanetResponse.class);
        PlanetResponse planetas = planets.getBody();
        return planetas.getResults();
    }
}