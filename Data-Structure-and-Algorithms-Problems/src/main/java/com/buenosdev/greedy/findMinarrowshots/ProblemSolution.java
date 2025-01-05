package com.buenosdev.greedy.findMinarrowshots;

import java.util.Arrays;
import java.util.Comparator;

public class ProblemSolution {

    /*
     * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
     * */


    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(value -> value[1]));

        var lastAddedBallon = points[0][1];
        var result = 1;

        for (int i = 1; i < points.length; i++) {
            if (lastAddedBallon >= points[i][0]) {
                if (points[i][1] >= lastAddedBallon) {
                    lastAddedBallon = points[i][1];
                }
            } else {
                lastAddedBallon = points[i][1];
                result = result + 1;
            }
        }
        return result;
    }
}
