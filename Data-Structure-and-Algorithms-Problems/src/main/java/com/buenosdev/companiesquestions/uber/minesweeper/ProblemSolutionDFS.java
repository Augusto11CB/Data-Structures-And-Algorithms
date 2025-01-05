package com.buenosdev.companiesquestions.uber.minesweeper;

class ProblemSolutionDFS {
    public char[][] updateBoard(char[][] board, int[] click) {
        var i = click[0];
        var j = click[1];
        if (board[i][j] == 'M') board[i][j] = 'X';
        else dfs(board, i, j);
        return board;
    }

    private char[][] dfs(char[][] board, int row, int col) {
        var mineCount = countMine(board, row, col);

        // IF there are adjacent mines, update the square with the mine count.
        if (mineCount > 0) {
            board[row][col] = (char) (mineCount + '0');
        }
        // ELSE, update the square to a 'B' and recursively reveal adjacent 'E' squares.
        else {
            board[row][col] = 'B';
            for (int x = row - 1; x <= row + 1; ++x) {
                for (int y = col - 1; y <= col + 1; y++) {
                    if (isWithinRange(board, x, y) && board[x][y] == 'E')
                        dfs(board, x, y); // Increment the mine counter
                }
            }
        }

        return board;
    }

    private static boolean isWithinRange(char[][] board, int x, int y) {
        return (x >= 0 && x < board.length) && (y >= 0 && y < board[0].length);
    }

    private int countMine(char[][] board, int row, int col) {
        // Iterate through the adjacent cells
        var mineCount = 0;

        for (int x = row - 1; x <= row + 1; x++) {

            for (int y = col - 1; y <= col + 1; y++) {
                // Check if the adjacent cell is within the board and if it contains a mine
                if (
                        x >= 0 && x < board.length &&
                                y >= 0 && y < board[0].length &&
                                board[x][y] == 'M'
                ) {
                    mineCount++; // Increment the mine counter
                }
            }
        }

        return mineCount;
    }

    /*
    * Time Complexity: O(n * m)
    *   The time complexity is determined by the number of times dfs is invoked;
    *
    *   Each cell is visited at most once. Why??? Because after being visited it is changed from 'E' to 'B'
    *   and we only apply the dfs in when it is 'E';
    *
    *   For each cell we visit, we inspect its adjacent cells (at most 8);
    *
    *   The time complexity is thus O(m * n) since in the worst-case scenario, we might end up visiting each cell once.
    * */
}