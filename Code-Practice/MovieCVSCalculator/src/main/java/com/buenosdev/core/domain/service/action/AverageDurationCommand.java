package com.buenosdev.core.domain.service.action;

import com.buenosdev.core.domain.entity.Movie;

import java.util.List;

public class AverageDurationCommand implements Command<Double> {
    @Override
    public CommandType getCommandType() {
        return CommandType.AVERAGE_DURATION;
    }

    @Override
    public Double execute(List<Movie> movies) {
        var size = (double) movies.size();
        var durationTotal = movies.stream().mapToInt(Movie::getDuration).sum();

        return size * durationTotal;
    }
}
