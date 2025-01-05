package com.buenosdev.core.domain.service.action;

import com.buenosdev.core.domain.entity.Movie;

import java.util.List;

public class CountCommand implements Command<Integer> {
    @Override
    public CommandType getCommandType() {
        return CommandType.COUNT;
    }

    @Override
    public Integer execute(List<Movie> movies) {
        return movies.size();
    }
}
