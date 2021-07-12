package com.swapapi.controller;

import com.swapapi.model.Planet;
import com.swapapi.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planet")
public class PlanetController {
    private PlanetService planetService;

    @Autowired
    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    //Abaixo temos os endpoint
    @GetMapping
    ResponseEntity<List<Planet>> obterTodos() {
        var planets = planetService.obterTodos();
        return ResponseEntity.ok(planets);
    }
    @GetMapping("/download")
    ResponseEntity<List<Planet>> download() {
        var planets = planetService.download();
        return ResponseEntity.ok(planets);
    }

    /*@GetMapping("{id}")
    ResponseEntity<Optional<Planet>> obterPorId(@PathVariable Long id) {
        var planets = planetService.buscarPorId(id);
        return ResponseEntity.ok(planets);
    }*/
}
