package com.buenosdev.core.domain.service.action;

import com.buenosdev.core.domain.entity.Movie;

import java.util.List;

public class AverageRatingCommand implements  Command<Double>{

    @Override
    public CommandType getCommandType() {
        return CommandType.AVERAGE_RATING;
    }

    @Override
    public Double execute(List<Movie> movies) {
        var size = (double) movies.size();
        var sumRatings = movies.stream().mapToInt(Movie::getRating).sum();
        return sumRatings/size;
    }
}
