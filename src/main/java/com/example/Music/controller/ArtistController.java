package com.example.Music.controller;

import com.example.Music.Entity.Artist;
import com.example.Music.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
@CrossOrigin(origins = "http://localhost:5173")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    private ResponseEntity<List<Artist>> getAll(){
        List<Artist> artists = artistService.getAll();
        return  artists == null ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(artists);
    }

    @PostMapping
    private ResponseEntity<Artist> create(@RequestBody Artist artist) {
        Artist saved = artistService.save(artist);
        return saved != null
                ? ResponseEntity.status(HttpStatus.CREATED).body(saved)
                : ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<Artist> update(@PathVariable Long id, @RequestBody Artist artist) {
        Artist updated = artistService.update(id, artist);
        return updated != null ? ResponseEntity.ok(updated)
                : ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        artistService.delete(id);
    }

}
