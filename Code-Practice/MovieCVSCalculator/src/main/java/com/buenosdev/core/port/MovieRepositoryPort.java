package com.buenosdev.core.port;

import com.buenosdev.core.domain.entity.Movie;

import java.util.List;

public interface MovieRepositoryPort {
    List<Movie> getAllMovies();

    List<Movie> getMovie(String movieName);
}
