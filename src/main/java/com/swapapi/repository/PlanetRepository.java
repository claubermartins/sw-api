package com.swapapi.repository;

import com.swapapi.model.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet,Long>{
    Page<Planet>findAll(Pageable pageable);
    List<Planet>findByPopulationBetween(Long pop1, Long pop2);
    Optional<Planet> findByNameIgnoreCase(String name);
}
