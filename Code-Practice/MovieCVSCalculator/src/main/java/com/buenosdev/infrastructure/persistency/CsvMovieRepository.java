package com.buenosdev.infrastructure.persistency;

import com.buenosdev.core.domain.entity.Genre;
import com.buenosdev.core.domain.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvMovieRepository {
    private final List<Movie> movies;
    private static Logger LOGGER = LoggerFactory.getLogger(CsvMovieRepository.class);

    // private final static Logger logger = Logger.getLogger(CsvMovieRepository.class.getName());


    public CsvMovieRepository(String filePath) throws IOException {
        this.movies = new ArrayList<>();
        loadFromCSV(filePath);
    }

    private void loadFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                List<Genre> genre = getGenre(values[1]);
                int rating = Integer.parseInt(values[2]);
                int duration = Integer.parseInt(values[3]);
                addMovie(new Movie(name, rating, duration, genre));
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Error loading file: " + filePath, e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            LOGGER.error("IOException loading file: " + filePath, e);
            throw new RuntimeException(e);
        }
    }

    private static List<Genre> getGenre(String values) {
        String[] genresStr = values.split(";");
        List<Genre> genres = new ArrayList<>();
        for (String genre : genresStr) {
            genres.add(Genre.valueOf(genre.trim()));
        }

        return genres;
    }

    private void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }
}