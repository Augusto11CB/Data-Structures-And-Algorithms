package com.buenosdev.usecase.show;

import com.buenosdev.entity.Cinema;
import com.buenosdev.entity.Movie;
import com.buenosdev.entity.Show;
import com.buenosdev.usecase.show.observer.ShowObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowManagementUseCaseImpl implements ShowManagementUseCase {
    private Map<Integer, Show> cache = new HashMap<>();
    private List<ShowObserver> observers = new ArrayList<>();

    @Override
    public Show addShow(int showId, Movie movie, Cinema cinema, int screenId, long starttime, long endtime) {
        if (cache.containsKey(showId)) return cache.get(showId);

        var newShow = new Show(
                cinema,
                movie,
                starttime,
                endtime,
                screenId
        );

        cache.put(showId, newShow);

        return newShow;
    }

    @Override
    public Show getShow(int showId) {
        return cache.get(showId);
    }

    @Override
    public void addObserver(ShowObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAll(Show show) {
        for (ShowObserver observer : observers) {
            observer.update(show);
        }
    }
}
