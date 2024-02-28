package com.buenosdev.greedy.canattendmeetings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProblemSolution {
    /*
    https://leetcode.com/problems/meeting-rooms/description/
    https://www.lintcode.com/problem/920/description
    * */

    public static void main(String[] args) {
        var psA = new ProblemSolution();

        var array = new ArrayList<Interval>();
        array.add(new Interval(5, 6));
        array.add(new Interval(4, 7));
        array.add(new Interval(1, 2));
        array.add(new Interval(2, 3));
        array.add(new Interval(3, 7));

        psA.canAttendMeetings(array);

    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.end, i2.end)); // COOL FEATURE
        var lastSelectedIntervalEnd = Integer.MIN_VALUE;
        var nonSelectedIntervals = 0;
        for (Interval i : intervals) {
            if (i.start >= lastSelectedIntervalEnd) {
                lastSelectedIntervalEnd = i.end;

            } else {
                nonSelectedIntervals = nonSelectedIntervals + 1;
            }
        }
        return nonSelectedIntervals == 0;
    }

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}