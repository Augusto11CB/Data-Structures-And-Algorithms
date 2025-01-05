package com.buenosdev.usecase.cinema;

import com.buenosdev.entity.Cinema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaManagementUseCaseImpl implements CinemaManagementUseCase {
    private Map<Integer, Cinema> cache = new HashMap<>();


    @Override
    public Cinema addCinema(int cinemaId, int cityId, int screenCount, int rows, int columns) {

        if(cache.containsKey(cinemaId)) return cache.get(cinemaId);

//        validateCity(cityId);
//        validateScreenCount(screenCount);
//        validateRowAndCols(rows, columns);

        var newCinema = new Cinema(
                cinemaId,
                cityId,
                screenCount,
                rows,
                columns
        );

        cache.put(cinemaId, newCinema);

        return newCinema;
    }


    @Override
    public Cinema getCinema(int cinemaId) {
        return cache.get(cinemaId);
    }

    private int nextId = 0;

    private int getNextId(){
        var resp = nextId;
        nextId += 1;
        return resp;
    }
}
