package com.swapapi.api;

import com.swapapi.model.Planet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.Arrays;
import java.util.List;

public class SwapApi {
    public List<Planet> obterTodos() {
        RestTemplate restTemplate = new RestTemplate();
        String urlBase = "https://swapi.dev/api/planets/";

        System.out.println("Passei!");
        HttpHeaders header = new HttpHeaders();
        header.set("ContentType", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(header);

        ResponseEntity<Planet[]> planets = restTemplate.exchange(urlBase, HttpMethod.GET, entity, Planet[].class);

        return Arrays.asList(planets.getBody());
    }
}