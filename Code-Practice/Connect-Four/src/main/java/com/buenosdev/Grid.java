package com.buenosdev;

import java.util.HashMap;

public class Grid {
    private int numberOfDiscs;

    private int numberOfRows;

    private int numberOfColumns;

    private int[][] grid;


    public Grid(
            int numberOfDiscs,
            int numberOfRows,
            int numberOfColumns

    ) {
        this.numberOfDiscs = numberOfDiscs;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;


        this.grid = new int[numberOfRows][numberOfColumns];
        this.initGrid();
    }

    public int place(GridPosition piece, int column) {
        if (!areCoordinatesInvalid(column)) {
            for (int row = grid.length - 1; row >= 0; row--) {
                if (grid[row][column] == GridPosition.EMPTY.ordinal()) {
                    grid[row][column] = piece.ordinal();
                    return row;
                }
            }
        }
        throw new RuntimeException("Player: " + piece.ordinal() + " Illegal column position.");
    }

    public void initGrid() {
        this.grid = new int[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                grid[i][j] = GridPosition.EMPTY.ordinal();
            }
        }
    }

    public boolean checkWinner(GridPosition piece, int row, int column) {
        return checkHorizontal(piece, row) ||
                checkVertical(piece, column) ||
                checkDiagonalRight(piece, row, column) ||
                checkDiagonalLeft(piece, row, column);
    }

    private boolean checkVertical(GridPosition piece, int column) {
        var count = 0;
        for (int r = 0; r < this.numberOfRows; r++) {
            if (this.grid[r][column] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == numberOfDiscs) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontal(GridPosition piece, int row) {
        int count = 0;
        for (int c = 0; c < this.numberOfColumns; c++) {
            if (this.grid[row][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == numberOfDiscs) {
                return true;
            }
        }
        return false;
    }


    private boolean checkDiagonalRight(GridPosition piece, int row, int column) {
        var count = 0;
        for (int r = 0; r < this.numberOfRows; r++) {
            int c = row + column - r; // row + col = r + c, for a diagonal
            if (c >= 0 && c < this.numberOfColumns && this.grid[r][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == numberOfDiscs) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalLeft(GridPosition piece, int row, int column) {
        var count = 0;
        for (int r = 0; r < this.numberOfRows; r++) {
            int c = column - row + r; // row - col = r - c, for an anti-diagonal
            if (c >= 0 && c < this.numberOfColumns && this.grid[r][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == numberOfDiscs) {
                return true;
            }
        }
        return false;
    }

    private boolean areCoordinatesInvalid(int column) {
        return column < 0 || column >= grid[0].length;
    }

    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void printGrid() {
        System.out.println("Board:");
        for (int row = 0; row < numberOfRows; row++) {
            var rowSb = new StringBuilder();
            for (int column = 0; column < numberOfColumns; column++) {
                rowSb.append(GridPosition.getIdPostion(grid[row][column])).append(" ");

            }
            System.out.println(rowSb.toString());
        }
        System.out.println();
    }
}
