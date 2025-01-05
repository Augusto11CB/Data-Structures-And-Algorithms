package com.buenosdev;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(6, 7, 8);
        Game game = new Game(grid, 4);
        game.play();
    }
}