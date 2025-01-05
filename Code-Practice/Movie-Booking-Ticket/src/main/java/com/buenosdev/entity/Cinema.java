package com.buenosdev.entity;

import java.util.List;

public class Cinema {
    private int id;

    private int city;

    private int screenCount;

    private int row;

    private int column;

    // private List<Screen> screens;


    public Cinema(int id, int city, int screenCount, int row, int column) {
        this.id = id;
        this.city = city;
        this.screenCount = screenCount;
        this.row = row;
        this.column = column;
    }

    public int getId() {
        return id;
    }

    public int getCity() {
        return city;
    }

    public int getScreenCount() {
        return screenCount;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
