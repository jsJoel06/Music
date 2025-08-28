package com.example.Music.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "music")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private String name;
    private String album;
    private String genre;
    private int year;

}
