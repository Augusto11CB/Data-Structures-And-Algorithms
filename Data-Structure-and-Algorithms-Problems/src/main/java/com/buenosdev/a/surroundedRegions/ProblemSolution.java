package com.buenosdev.a.surroundedRegions;

public class ProblemSolution {

    /*
     * Notice that an 'O' should not be flipped if:
     * - (1) It is on the border, or
     * - (2) It is adjacent to an 'O' that should not be flipped.
     * 
     * XXXXX
     * XXOXX <-- this guy can't be flipped because of (2)
     * OOOXX
     * 
     */

    /*
     * The intuition behind the solution to the "Surrounded Regions" problem is to
     * identify which 'O's cannot be flipped to 'X' because they are either on the
     * border or connected to an 'O' on the border.
     * 
     */

    public void solve(char[][] board) {

        for (int j = 0; j < board[0].length; j++) {
            // During the DFS, change all 'O's that are connected to border 'O's to a
            // temporary marker (e.g., 'M') to indicate that these 'O's should not be flipped.
            dfs(board, 0, j, board.length, board[0].length);
            dfs(board, board.length - 1, j, board.length, board[0].length);
        }

        for (int i = 0; i < board.length; i++) {
            // During the DFS, change all 'O's that are connected to border 'O's to a
            // temporary marker (e.g., 'M') to indicate that these 'O's should not be flipped.
            dfs(board, i, 0, board.length, board[0].length);
            dfs(board, i, board[0].length - 1, board.length, board[0].length);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'M')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int row, int column, int rSize, int cSize) {
        if (row < 0 || row >= rSize || column < 0 || column >= cSize || board[row][column] != 'O')
            return;

        board[row][column] = 'M';

        dfs(board, row - 1, column, rSize, cSize);
        dfs(board, row + 1, column, rSize, cSize);
        dfs(board, row, column - 1, rSize, cSize);
        dfs(board, row, column + 1, rSize, cSize);
    }

    public void solveFAILED(char[][] board) {

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                if (board[i][j] == 'O') {
                    if ((i - 1 >= 0 && board[i - 1][j] == 'O') ||
                            (i + 1 < board.length - 1 && board[i + 1][j] == 'O') ||
                            (j - 1 >= 0 && board[i][j - 1] == 'O') ||
                            (j + 1 < board[i].length - 1 && board[i][j + 1] == 'O')) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

    }
}
