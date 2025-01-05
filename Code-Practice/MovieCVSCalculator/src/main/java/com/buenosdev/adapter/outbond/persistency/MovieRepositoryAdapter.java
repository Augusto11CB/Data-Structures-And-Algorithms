package com.buenosdev.adapter.outbond.persistency;

import com.buenosdev.core.domain.entity.Movie;
import com.buenosdev.core.port.MovieRepositoryPort;
import com.buenosdev.infrastructure.persistency.CsvMovieRepository;

import java.util.List;

public class MovieRepositoryAdapter implements MovieRepositoryPort {
    private CsvMovieRepository repository;

    public MovieRepositoryAdapter(CsvMovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return repository.getAllMovies();
    }

    @Override
    public List<Movie> getMovie(String movieName) {
        return repository.getAllMovies()
                .stream()
                .filter(m -> m.getName().equals(movieName))
                .toList();
    }
}
