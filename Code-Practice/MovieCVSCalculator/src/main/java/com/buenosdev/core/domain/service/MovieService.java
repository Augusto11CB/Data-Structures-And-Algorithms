package com.buenosdev.core.domain.service;

import com.buenosdev.core.domain.entity.Movie;
import com.buenosdev.core.domain.service.action.CommandType;

import java.util.List;

public interface MovieService {

    public <T> T executeCommandForMovies(CommandType commandType);


    // public List<Movie> getMoviesByCriteria();
}
