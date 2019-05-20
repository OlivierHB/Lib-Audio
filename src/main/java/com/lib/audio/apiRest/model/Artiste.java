package com.lib.audio.apiRest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity(name="artist")
public class Artiste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ArtistId")
    private Integer id;

    @Column(name="Name")
    private String name;

    @OneToMany(mappedBy = "artist")
    @JsonManagedReference
    private List<Album> albums;

    public Artiste(){}

    public Artiste(Integer id, String name, List<Album> albums) {
        this.id = id;
        this.name = name;
        this.albums = albums;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
