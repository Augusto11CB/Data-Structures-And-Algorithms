package com.buenosdev.backtracking.wordSearch;


class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, i, j)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col) {
        if (row >= board.length || row < 0 || col >= board[row].length || col < 0) {
            if(word.length() == 0) return true;
            return false;
        }

        if (word.length() == 0) return true;

        if (board[row][col] == word.charAt(0)) {

            // tmp will be used to 'backtrack' later
            var tmp = board[row][col];

            // mark the current cell as visited by replacing it with '+'
            board[row][col] = '+';

            var newW = word.substring(1);
            var up = dfs(board, newW, row + 1, col);
            var right = dfs(board, newW, row, col + 1);
            var left = dfs(board, newW, row, col - 1);
            var down = dfs(board, newW, row - 1, col);

            // !!! backtrack by replacing the current cell with its original value
            board[row][col] = tmp;

            // check all 4 adjacent cells recursively
            return up || right || left || down;
        }
        return false;
    }
}