package com.buenosdev.greedy.eraseoverlapintervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class ProblemSolution {
    /*
    https://leetcode.com/problems/non-overlapping-intervals/
    * */

    public static void main(String[] args) {
        var psA = new ProblemSolution();
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        var lastSelectedIntervalEnd = Integer.MIN_VALUE;
        var nonSelectedIntervals = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= lastSelectedIntervalEnd) {
                lastSelectedIntervalEnd = interval[1];

            } else {
                nonSelectedIntervals = nonSelectedIntervals + 1;
            }
        }
        return nonSelectedIntervals;
    }

}