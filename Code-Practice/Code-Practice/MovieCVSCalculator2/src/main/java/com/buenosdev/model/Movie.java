package com.buenosdev.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

public class Movie {

    private String name;

    private BigDecimal rating;

    private Duration duration;

    private List<Genre> genre;

    public Movie(String name, BigDecimal rating, Duration duration, List<Genre> genre) {
        this.name = name;
        this.rating = rating;
        this.duration = duration;
        this.genre = genre;
    }

}
