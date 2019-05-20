package com.lib.audio.apiRest.controller;


import com.lib.audio.apiRest.exceptions.RessourceNotFoundException;
import com.lib.audio.apiRest.model.Artiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lib.audio.apiRest.service.ArtisteService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtisteController {

    @Autowired
    ArtisteService artisteService;

    //------------------------------ GET Single ID ----------------------------------------
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Artiste findArtistById(@PathVariable(value = "id") Integer id) throws Exception {
        return artisteService.findById(id);
    }

    //------------------------------ GET ALL ARTISTS ------------------------------
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Artiste> getArtistsList() {
        return artisteService.findAllArtists();
    }

    //------------------------------ PUT ------------------------------------------
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> putArtiste(@PathVariable(value = "id") Integer idArtist,
                                        @Valid @RequestBody Artiste artiste) {
        Artiste artisteToPut = artisteService.findById(idArtist);
        artiste.setId(idArtist);
        if (artisteToPut != null) {
            return new ResponseEntity<>(artisteService.saveArtist(artiste), HttpStatus.OK);
        } else {
            throw new RessourceNotFoundException("Artist", "id", idArtist.toString());
        }
    }

    //------------------------------ Search By Name --------------------------------
    @RequestMapping(params = "name")
    public List<Artiste> artistes(@RequestParam(value = "name") String name) throws Exception {
        return artisteService.findByName(name);
    }

    //------------------------------ Pageable -------------------------------------
    @RequestMapping("")
    public Page<Artiste> listeEmployeByAsc(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size, @RequestParam(value = "sortDirection") String sortDirection, @RequestParam(value = "sortProperty") String sortProperty) {
        return artisteService.findAll(page, size, sortDirection, sortProperty);
    }

    //------------------------------ POST ------------------------------------------
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json",
            value = ""
    )
    public Artiste artist(@RequestBody Artiste a) {
        return artisteService.saveArtist(a);
    }

    //------------------------------ DELETE ----------------------------------------
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void artistDelete(@PathVariable(value = "id") Integer id) {
        artisteService.deleteArtiste(id);
    }

}
