package com.lib.audio.apiRest.controller;

import com.lib.audio.apiRest.exceptions.RessourceNotFoundException;
import com.lib.audio.apiRest.model.Album;
import com.lib.audio.apiRest.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    //------------------------------ PUT ----------------------------------------
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?>putAlbum(@PathVariable(value = "id") Integer idAlbum,
        @Valid @RequestBody Album album ){
        Album albumToPut = albumService.findById(idAlbum);
        album.setId(idAlbum);
        if(albumToPut != null){
            return new ResponseEntity<>(albumService.saveAlbum(album),HttpStatus.OK);
        }else{
            throw new RessourceNotFoundException("Album","id",idAlbum.toString());
        }
    }

    //------------------------------ GET ALL Albums ----------------------------------------
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Album>getAlbumsList(){
        return albumService.findAllAlbums();
    }

    //------------------------------ GET SINGLE ID ----------------------------------------
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Album getAlbumById(@PathVariable(value = "id") int albumId) {
        return albumService.findById(albumId);
    }

    //------------------------------ POST ----------------------------------------
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json",
            value = ""
    )
    public Album album(@RequestBody Album a)
    {
        return albumService.saveAlbum(a);
    }

    //------------------------------ DELETE ----------------------------------------
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void artistDelete(@PathVariable(value = "id")Integer id) {
        albumService.deleteAlbum(id);
    }
}


