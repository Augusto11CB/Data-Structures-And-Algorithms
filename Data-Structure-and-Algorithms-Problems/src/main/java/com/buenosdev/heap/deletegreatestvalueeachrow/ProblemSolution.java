package com.buenosdev.heap.deletegreatestvalueeachrow;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ProblemSolution {

    // (Heap) Problem B: Delete Greatest Value in Each Row

    /*
    https://leetcode.com/problems/delete-greatest-value-in-each-row/description/
    **/

    /*
     * */


    public int deleteGreatestValue(int[][] grid) {
        PriorityQueue[] arrayOfHeaps = new PriorityQueue[grid.length];

        for (int i = 0; i < grid.length; i++) {
            var aux = new PriorityQueue<Integer>((a, b) -> b - a);
            for (int j = 0; j < grid[0].length; j++) {
                aux.add(grid[i][j]);
            }
            arrayOfHeaps[i] = aux;
        }


        int result = 0;
        // (for-1) See column I
        // (for-2) See all the lines of Column I
        for (int i = 0; i < grid[0].length; i++) {
            int num = -1;
            for (int j = 0; j < grid.length; j++) {
                PriorityQueue<Integer> priorityQueue = arrayOfHeaps[j];
                int temp = priorityQueue.poll();

                num = Math.max(num, temp);
            }
            result += num;
        }
        return result;
    }


       /*
        Time Complexity: O((n * m log m) + n * m)
        - (1) Converting the given grid to a list of heaps is O(n * m log m):
            - The creation of a priority queue takes O(m log m) time, where m is the number of columns in the grid. This operation is performed for each row, so the total time complexity is O(n * m log m), where n is the number of rows.
        - (2) Comparing all lines of all Columns: O (n * m)
            - n is the number of columns
            - m is the number of lines
        Space Complexity: O(n)
        */


    public int deleteGreatestValueV2(int[][] grid) {
        for (int[] arr : grid) {
            //  O(nlog(n))
            Arrays.sort(arr);
        }

        int sum = 0;

        for (int col = 0; col < grid[0].length; col++) {
            int maxValue = 0;

            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] > maxValue) {
                    maxValue = grid[row][col];
                }
            }

            sum += maxValue;
        }

        return sum;
    }


    public static void main(String[] args) {
    }
}