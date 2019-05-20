package com.lib.audio.apiRest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="AlbumId")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="ArtistId")
    @JsonBackReference
    private Artiste artist;

    @Column(name="Title")
    private String title;

    public Album() {
    }

    public Album(Integer id, String title, Artiste artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artiste getArtist() {
        return artist;
    }

    public void setArtist(Artiste artist) {
        this.artist = artist;
    }
}
