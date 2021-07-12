package com.swapapi.service;

import com.swapapi.exceptions.DuplicatedResourceException;
import com.swapapi.exceptions.ResourceNotFoundException;
import com.swapapi.model.Planet;
import com.swapapi.api.SwapApi;

import com.swapapi.planetrepository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {


    private PlanetRepository planetRepository;
    @Autowired
    public PlanetService(PlanetRepository planetRepository){
        this.planetRepository = planetRepository;
    }

    public Page<Planet>obterTodos(Pageable pageable){     //otimiza a busca para não vir todos de uma vez
        return planetRepository.findAll(pageable);
    }
    public List<Planet> obterTodos(){
        return planetRepository.findAll();
    }
    public Optional<Planet> buscaPorId(Long id){
    return planetRepository.findById(id);
    }
    public Optional<Planet> buscarPorName(String name){
        return planetRepository.findByNameIgnoreCase(name);
    }
    //Crud abaixo
    public Planet salvar(Planet planet){ //aqui é feito o post
        var podeSalvar = planet.getId() == null;
        if(podeSalvar)
            return planetRepository.save(planet);
        else
            throw new DuplicatedResourceException();
    }
    public Planet update(Planet planet){ //aqui é feito o put
        var podeAtualizar = planet.getId() != null;
        if (podeAtualizar)
            return planetRepository.save(planet);
        else
            throw new ResourceNotFoundException();
    }
    public void delete(Planet planet){
        var podeDeletar = planet.getId() != null;
        if (podeDeletar)
            planetRepository.delete(planet);
        else
            throw new ResourceNotFoundException();
    }
    public List<Planet> download(){
        SwapApi swapApi = new SwapApi();
        swapApi.obterTodos();
        List<Planet> planets = swapApi.obterTodos();
       return planetRepository.saveAll(planets);
    }


}
