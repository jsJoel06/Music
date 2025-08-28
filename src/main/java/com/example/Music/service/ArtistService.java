package com.example.Music.service;

import com.example.Music.Entity.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> getAll();

    Artist getById(Long id);

    Artist save(Artist artist);

    Artist update(Long id, Artist artist);

    void delete(Long id);
}
