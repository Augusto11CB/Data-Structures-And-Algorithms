package com.buenosdev.greedy.boatstosave;

import java.util.Arrays;

class ProblemSolution {

    // (Greedy Algorithm) Problem A: Boats to Save People

    /*
    https://leetcode.com/problems/boats-to-save-people/description/
     **/

    /*
     * */

    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        int result = 0; // Count of boats

        while (i < j) {

        }

        // When last person is left.
        if (i == j) {
            result++;
        }
        return result;
    }

    public int numRescueBoatsFailedTwo(int[] people, int limit) {
        var result = 0;

        Arrays.sort(people);

        var i = 1;
        var j = people.length - 2;
        var left = people[0];
        var right = people[people.length - 1];
        while (i < j) {
            if (left + right == limit) {
                result = result + 1;
                left = people[i];
                right = people[j];
                i = i + 1;
                j = j - 1;
            }
            if (left + right > limit) {
                result = result + 1;
                right = people[j];
                j = j - 1;
            } else {
                left = left + people[i];
                i = i + 1;
            }
        }

        if (people.length == 2) {
            if (left + right == limit) return 1;
            else return 2;
        }

        if (people.length < 2) return 1;

        if (j == i) {
            result = result + 1;
        }

        return result;
    }

    public int numRescueBoatsFailed(int[] people, int limit) {
        var result = 0;
        Arrays.sort(people);

        int i = 0;
        int currentWeight = 0;
        while (i < people.length) {
            if (currentWeight + people[i] < limit) {
                currentWeight = currentWeight + people[i];
                if (i == people.length - 1) result = result + 1;
            } else if (currentWeight + people[i] == limit) {
                currentWeight = 0;
                result = result + 1;
            } else {
                currentWeight = people[i];
                result = result + 1;
                if (i == people.length - 1) result = result + 1;
            }

            i++;

        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new ProblemSolution();
        int[] people = {10, 55, 70, 20, 90, 85};
        int limit = 100;

        int result = solution.numRescueBoats(people, limit);
        System.out.println("Minimum number of boats required: " + result);
        // Expected output: "Minimum number of boats required: 2"

        int[] people2 = {1, 2};
        int limit2 = 3;

        int result2 = solution.numRescueBoats(people2, limit2);
        System.out.println("Minimum number of boats required: " + result2);
    }
}