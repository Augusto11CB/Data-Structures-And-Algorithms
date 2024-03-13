package com.buenosdev.greedy.minmeetingrooms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ProblemSolution {
    /*
    Meeting Room II
    https://www.lintcode.com/problem/919/
    * */

    public static void main(String[] args) {
        var psA = new ProblemSolution();

        var array = new ArrayList<Interval>();
        array.add(new Interval(5, 6));
        array.add(new Interval(4, 7));
        array.add(new Interval(1, 2));
        array.add(new Interval(2, 3));
        array.add(new Interval(3, 7));

        psA.minMeetingRooms(array);

    }

    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start)); // Sort by start time

        var mapOfRooms = new HashMap<Integer, Interval>();
        var nextIdRoom = 0;

        for (Interval i : intervals) {
            var wasIntervalAdded = false;

            for (Map.Entry<Integer, Interval> room : mapOfRooms.entrySet()) {
                if (i.start >= room.getValue().end) {
                    mapOfRooms.put(room.getKey(), i);
                    wasIntervalAdded = true;
                    break;
                }
            }
            if (!wasIntervalAdded) {
                mapOfRooms.put(nextIdRoom, i);
                nextIdRoom = nextIdRoom + 1;
            }
        }
        return mapOfRooms.keySet().size();
    }

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

