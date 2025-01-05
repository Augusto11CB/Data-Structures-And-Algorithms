package com.buenosdev.core.domain.entity;

import java.util.List;

public class Movie {
    private String name;

    private int rating;

    private int duration;

    private List<Genre> genre;

    public Movie(String name, int rating, int duration, List<Genre> genre) {
        this.name = name;
        this.rating = rating;
        this.duration = duration;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public List<Genre> getGenre() {
        return genre;
    }
}
