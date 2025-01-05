package com.buenosdev.core.domain.service;

import com.buenosdev.core.domain.entity.Movie;
import com.buenosdev.core.domain.service.action.Command;
import com.buenosdev.core.domain.service.action.CommandType;
import com.buenosdev.core.port.MovieRepositoryPort;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class MovieServiceImpl implements MovieService {
    private Map<CommandType, Command> commands;
    private MovieRepositoryPort movieRepository;

    public MovieServiceImpl(Map<CommandType, Command> commands, MovieRepositoryPort movieRepositoryPort) {
        this.commands = commands;
        this.movieRepository = movieRepositoryPort;
    }

    @Override
    public <T> T executeCommandForMovies(CommandType commandType) {
        List<Movie> movies = movieRepository.getAllMovies();
        return (T) commands.get(commandType).execute(movies);
    }


    public <T> List<String> executeCommandForMovies(T commandType) {
        List<Movie> movies = movieRepository.getAllMovies();
        return emptyList();
    }
}
