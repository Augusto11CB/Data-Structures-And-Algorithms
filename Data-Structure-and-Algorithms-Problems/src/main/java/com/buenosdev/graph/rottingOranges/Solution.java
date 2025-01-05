package com.buenosdev.graph.rottingOranges;

import java.util.LinkedList;

public class Solution {

    private class Pair {

        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        var queue = new LinkedList<Pair>();
        var freshOranges = 0;
        var timeElapsed = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0;


        var adjPositions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS to rot adjacent oranges
        while (!queue.isEmpty() && freshOranges > 0) {
            var rottenOranges = queue.size();

            for (int i = 0; i < rottenOranges; i++) {
                var rottenOrange = queue.poll();

                for (int[] adjPosition : adjPositions) {
                    var col = rottenOrange.col + adjPosition[0];
                    var row = rottenOrange.row + adjPosition[1];

                    if (isValidAndFresh(grid, row, col)) {
                        grid[row][col] = 2;
                        queue.add(new Pair(row, col));
                        freshOranges -= 1;
                    }
                }
            }

            timeElapsed += 1;
        }

        return freshOranges != 0 ? -1 : timeElapsed;
    }

    private boolean isValidAndFresh(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1;
    }
}
