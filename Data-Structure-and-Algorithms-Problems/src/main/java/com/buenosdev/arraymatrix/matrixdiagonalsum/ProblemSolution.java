package com.buenosdev.arraymatrix.matrixdiagonalsum;

class ProblemSolution {

    // (Matrix) Problem 2: Matrix Diagonal Sum

    /*
    Given a square matrix mat, return the sum of the matrix diagonals.
    Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that
    are not part of the primary diagonal.
    * */

    /*
    Ex 1:
    Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
    Output: 25
    Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
    Notice that element mat[1][1] = 5 is counted only once.

    Ex 2:
    Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
    Output: 8
    * */

    public static int diagonalSum(int[][] mat) {
        // n == mat.length == mat[i].length
        int lengthColumnRow = mat.length;
        int leftToRightDiagonal = 0;
        int rightToLeftDiagonal = 0;
        int j = lengthColumnRow - 1;

        for (int i = 0; i < lengthColumnRow; i++) {
            leftToRightDiagonal = leftToRightDiagonal + mat[i][i];
            rightToLeftDiagonal = rightToLeftDiagonal + mat[i][j - i];
        }
        int totalSum = rightToLeftDiagonal + leftToRightDiagonal;

        if (lengthColumnRow % 2 != 0) totalSum -= mat[lengthColumnRow / 2][lengthColumnRow / 2];
        return totalSum;
    }
}
/*
Time Complexity:
 - O(n): We traverse through each row of the matrix exactly once to get the elements for our diagonal sums, where ( n )
  is the number of rows (or columns, since it's a square matrix).

Space Complexity:
 - O(1)
*/