package com.lib.audio.apiRest.repository;

import com.lib.audio.apiRest.model.Artiste;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtisteRepository extends JpaRepository<Artiste, Integer> {

    Page<Artiste> findAll(Pageable pageable);

    List<Artiste> findByNameContaining(String name);
}
