package com.buenosdev.arraymatrix.findthehighestaltitude;

class ProblemSolution {

    // Problem 4: Find the Highest Altitude

    /*
    You are given an array of integers representing a journey on a bike, wherein each number indicates a climb or descent
    in altitude, measured as a gain or loss of height. The rider starts at altitude 0. Your task is to determine the
    highest altitude the biker reaches at any point during the journey.
     */

    /*
    Example 1
    Input: [-5, 1, 5, 0, -7]
    Expected Output: 1
    Justification: The altitude changes are [-5, -4, 1, 1, -6], where 1 is the highest altitude reached.
     */

    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();
        // Example 1
        System.out.println(solution.largestAltitude(new int[]{-5, 1, 5, 0, -7})); // Expected: 1

        // Example 2
        System.out.println(solution.largestAltitude(new int[]{4, -3, 2, -1, -2})); // Expected: 4

        // Example 3
        System.out.println(solution.largestAltitude(new int[]{2, 2, -3, -1, 2, 1, -5})); // Expected: 4


    }

    // Helper method to print array elements
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

//    Input: [-5, 1, 5, 0, -7]
//    Expected Output: 1
//    Justification: The altitude changes are [0,-5,-4,1,1,-6], where 1 is the highest altitude reached.

//    Input: [4, -3, 2, -1, -2]
//    Expected Output: 4
//    Justification: The altitude changes are [4, 1, 3, 2, 0], where 4 is the highest altitude reached.

    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int auxAltitude = 0;

        for (int currentGain : gain) {
            auxAltitude = currentGain + auxAltitude;
            if (maxAltitude < auxAltitude) maxAltitude = auxAltitude;
        }
        return maxAltitude;
    }
}

/*
Time Complexity:
 - O(n)

Space Complexity:
 - O(1)
*/