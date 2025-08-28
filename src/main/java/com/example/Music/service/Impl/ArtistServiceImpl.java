package com.example.Music.service.Impl;

import com.example.Music.Entity.Artist;
import com.example.Music.repository.ArtistRepository;
import com.example.Music.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist getById(Long id) {
        Artist artist = artistRepository.findById(id).orElse(null);
        return artist;
    }

    @Override
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist update(Long id, Artist artist) {
        Artist artist1 = artistRepository.findById(id).orElse(null);
        artist1.setTitle(artist.getTitle());
        artist1.setArtist(artist.getArtist());
        artist1.setName(artist.getName());
        artist1.setGenre(artist.getGenre());
        artist1.setAlbum(artist.getAlbum());
        artist1.setYear(artist.getYear());
        return artistRepository.save(artist1);
    }

    @Override
    public void delete(Long id) {
      artistRepository.deleteById(id);
    }
}
