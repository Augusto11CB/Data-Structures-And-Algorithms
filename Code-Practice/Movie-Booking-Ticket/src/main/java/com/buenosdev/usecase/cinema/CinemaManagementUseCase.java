package com.buenosdev.usecase.cinema;

import com.buenosdev.entity.Cinema;

public interface CinemaManagementUseCase {

    Cinema addCinema(int cinemaId, int cityId, int screenCount, int rows, int columns);

    Cinema getCinema(int cinemaId);

}
