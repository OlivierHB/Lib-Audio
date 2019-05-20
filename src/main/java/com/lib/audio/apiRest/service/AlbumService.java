package com.lib.audio.apiRest.service;

import com.lib.audio.apiRest.model.Album;
import com.lib.audio.apiRest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public void deleteAlbum(Integer idAlbumToDelete) {
        albumRepository.delete(idAlbumToDelete);
    }

    public Album saveAlbum(Album albumToSave) {
        return albumRepository.save(albumToSave);
    }

    public Album findById(Integer albumId){
       return albumRepository.findOne(albumId);
    }

    public List<Album> findAllAlbums(){
        return albumRepository.findAll();
    }
}
