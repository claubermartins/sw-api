package com.swapapi.planetrepository;

import com.swapapi.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface PlanetRepository extends JpaRepository<Planet, Long> {

        Optional<Planet> findByNameIgnoreCase(String name);
    }

