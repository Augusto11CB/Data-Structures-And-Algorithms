package com.buenosdev.core.domain.service.action;

import com.buenosdev.core.domain.entity.Movie;

import java.util.List;

public interface Command<T> {

    public CommandType getCommandType();

    public T execute(List<Movie> movies);

}
