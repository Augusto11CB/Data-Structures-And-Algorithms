package com.buenosdev.entity;

public class Show {
    private Cinema cinema;

    private Movie movie;

    private long startTime;

    private long endTime;

    private int screenId;

    public Show(Cinema cinema, Movie movie, long startTime, long endTime, int screenId) {
        this.cinema = cinema;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
        this.screenId = screenId;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Movie getMovie() {
        return movie;
    }
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
