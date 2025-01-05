package com.buenosdev.companiesquestions.uber.minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class ProblemSolutionBFS {

    public static void main(String[] args) {
        var obj = new ProblemSolutionBFS();
        List<Integer> test1 = Arrays.asList(1, 3, 6);
        List<Integer> result1 = obj.miroMiniumQuestion("RLL", 2, test1);
        System.out.println("Test 1 Result: " + result1); // Expected: [2, 3, 4]

        List<Integer> test2 = Arrays.asList(1, 3, 6);
        List<Integer> result2 = obj.miroMiniumQuestion("RRR", 2, test2);
        System.out.println("Test 2 Result: " + result2); // Expected: [1, 3, 1]

        List<Integer> test3 = Arrays.asList(0, 1, 2);
        List<Integer> result3 = obj.miroMiniumQuestion("LRL", 3, test3);
        System.out.println("Test 3 Result: " + result3); // Expected: [-1, 0, 1]

        List<Integer> test4 = Arrays.asList(0, 0, 0);
        List<Integer> result4 = obj.miroMiniumQuestion("RRR", 1, test4);
        System.out.println("Test 4 Result: " + result4); // Expected: [1, 1, 1]

        List<Integer> test5 = Arrays.asList(0, 2, 4);
        List<Integer> result5 = obj.miroMiniumQuestion("RLR", 2, test5);
        System.out.println("Test 5 Result: " + result5); // Expected: [1, 1, 5]
    }

    public List<Integer> miroMiniumQuestion(String command, int d, List<Integer> m) {
        var miniums = new ArrayList<Integer>(m);
        var takenPositions = new HashMap<Integer, Set<Integer>>();
        var ar = new int[command.length()];

        for (int i = 0; i < ar.length; i++) {
            ar[i] = command.charAt(i) == 'R' ? 1 : -1;
        }

        for (int i = 0; i < ar.length; i++) {
            var set = takenPositions.getOrDefault(miniums.get(i), new HashSet<Integer>());
            set.add(i);
            takenPositions.put(miniums.get(i), set);
        }

        // this hashset keeps track of the positions with more than one minium;
        var collision = new HashSet<Integer>();

        // this HashSet tells wich minium should change position
        var changeDirection = new HashSet<Integer>();
        while (d > 0) {
            checkIfChangeDirection(changeDirection, collision, takenPositions);

            for (int minium = 0; minium < miniums.size(); minium++) {
                if (changeDirection.contains(minium)) {
                    ar[minium] = ar[minium] * -1;
                    changeDirection.remove(minium);

                }
                // remove from the takenPositions map the miniums position before the 'jump';
                var oldPosition = miniums.get(minium);
                var positionOld = takenPositions.getOrDefault(oldPosition, new HashSet<>());
                positionOld.remove(minium);
                takenPositions.put(oldPosition, positionOld);
                collision.remove(oldPosition);

                // add in the takenPositions map the miniums position new position ('jump');
                var jump = miniums.get(minium) + ar[minium];
                var positionJ = takenPositions.getOrDefault(jump, new HashSet<>());
                positionJ.add(minium);
                takenPositions.put(jump, positionJ);
                miniums.set(minium, jump);


                // if more than one minium is in position, mark as collision
                if (positionJ.size() > 1)
                    collision.add(jump);

            }

            d--;
        }
        return miniums;
    }

    private void checkIfChangeDirection(HashSet<Integer> changeDirection, HashSet<Integer> collision, HashMap<Integer, Set<Integer>> takenPositions) {
        for (int idCollision : collision) {
            changeDirection.addAll(takenPositions.get(idCollision));
        }

    }

    public char[][] updateBoard(char[][] board, int[] click) {
        var i = click[0];
        var j = click[1];
        if (board[i][j] == 'M') board[i][j] = 'X';

        else {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(click);
            while (!queue.isEmpty()) {
                var coordinate = queue.poll();
                var row = coordinate[0];
                var col = coordinate[1];

                var mineCount = countMine(board, row, col);

                if (mineCount > 0) {
                    board[row][col] = (char) (mineCount + '0');
                } else {
                    board[row][col] = 'B';
                    processAdjacent(board, queue, row, col);
                }
            }

        }
        return board;
    }

    private static void processAdjacent(char[][] board, Queue<int[]> queue, int row, int col) {
        for (int x = row - 1; x <= row + 1; x++) {
            for (int y = col - 1; y <= col + 1; y++) {
                if (isWithinRangeAndUnrevealedEmptySquare(board, x, y)) {
                    queue.add(new int[]{x, y});
                    board[x][y] = 'B';
                }
            }
        }
    }

    private static boolean isWithinRangeAndUnrevealedEmptySquare(char[][] board, int x, int y) {
        return x >= 0 && x < board.length &&
                y >= 0 && y < board[0].length &&
                board[x][y] == 'E';
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


}