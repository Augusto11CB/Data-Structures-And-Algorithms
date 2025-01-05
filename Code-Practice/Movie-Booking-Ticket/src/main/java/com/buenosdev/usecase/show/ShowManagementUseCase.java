package com.buenosdev.usecase.show;

import com.buenosdev.entity.Cinema;
import com.buenosdev.entity.Movie;
import com.buenosdev.entity.Show;
import com.buenosdev.usecase.show.observer.ShowSubject;

import java.util.List;

public interface ShowManagementUseCase extends ShowSubject {
    Show addShow(int showId, Movie movie, Cinema cinema, int screenId, long starttime, long endtime);

    Show getShow(int showId);

}
