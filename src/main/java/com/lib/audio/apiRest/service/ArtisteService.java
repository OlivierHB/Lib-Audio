package com.lib.audio.apiRest.service;

import com.lib.audio.apiRest.model.Artiste;
import com.lib.audio.apiRest.repository.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class ArtisteService {


    @Autowired
    private ArtisteRepository artisteRepository;

    /*public Artiste findArtistById(Integer artisteId){
        return artisteRepository.findOne(artisteId);
    }*/

    public Artiste findById(Integer id) {
        if (artisteRepository.exists(id)) {
            return artisteRepository.findOne(id);
        } else {
            throw new EntityNotFoundException("Artiste avec id" + id + "n'existe pas.");
        }
    }

    public List<Artiste> findAllArtists() {
        return artisteRepository.findAll();
    }

    public List<Artiste> findByName(String name) {
        List<Artiste> artistes = artisteRepository.findByNameContaining(name);
        return artistes;
    }

    public Page<Artiste> findAll(Integer page, Integer size, String sortDirection, String sortProperty) {
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
        return artisteRepository.findAll(pageRequest);
    }

    //-------------------- Gestion doublon --------------------
    public Artiste saveArtist(Artiste artiste) {
        if (artisteRepository.findByNameContaining(artiste.getName()).size() == 0) {
            return artisteRepository.save(artiste);
        }else{
            throw new PersistenceException("L'artiste: "+artiste.getName()+" est déjà présent.");
        }
    }

    public Artiste updateArtiste(Integer id, Artiste artiste) {
        return artisteRepository.save(artiste);
    }

    public void deleteArtiste(Integer artistId) {
        artisteRepository.delete(artistId);
    }
}



