package com.buenosdev.entity;

public class Screen {

    private int id;

    private int seats[][];

    private int rows;

    private int columns;

    public Screen(int id, int rows, int columns) {
        this.id = id;
        this.seats = new int[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

}
