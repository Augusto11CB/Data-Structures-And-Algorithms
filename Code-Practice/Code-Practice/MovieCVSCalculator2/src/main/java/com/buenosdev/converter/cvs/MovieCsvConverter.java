package com.buenosdev.converter.cvs;

import com.buenosdev.model.Genre;
import com.buenosdev.model.Movie;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MovieCsvConverter implements CvsConverter<Movie> {

    @Override
    public Movie convert(String[] data) {
        return new Movie(
                getName(data),
                getRating(data),
                getDuration(data),
                getGenre(data)
        );
    }

    private BigDecimal getRating(String[] data) {

        return new BigDecimal(data[1]).setScale(2);
    }

    private String getName(String[] data) {
        return data[0];
    }

    private Duration getDuration(String[] data) {
        return Duration.ofMinutes(Long.parseLong(data[2]));
    }

    private List<Genre> getGenre(String[] data) {
        return Arrays.stream(data[2].split("\\|"))
                .map(this::parseGenre)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Genre parseGenre(String genreStr) {
        try {
            return Genre.valueOf(genreStr);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public Movie convert(String s) {
        return null;
    }
}
