package com.buenosdev.greedy.minmeetingrooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ProblemSolutionReviewA {
    /*
    Meeting Room II
    https://www.lintcode.com/problem/919/
    * */

    public static void main(String[] args) {
        var psA = new ProblemSolutionReviewA();

        var array = new ArrayList<Interval>();
        array.add(new Interval(5, 6));
        array.add(new Interval(4, 7));
        array.add(new Interval(1, 2));
        array.add(new Interval(2, 3));
        array.add(new Interval(3, 7));

        psA.minMeetingRooms(array);

    }

    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        // Sort the intervals by start time
        intervals.sort(Comparator.comparingInt(i -> i.start));

        // Use a priority queue to track the end time of meetings
        PriorityQueue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i.end));
        queue.offer(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            Interval earliest = queue.poll();

            if (current.start >= earliest.end) {
                // If the current meeting starts after the earliest meeting ends, they can use the same room
                earliest.end = current.end;
            } else {
                // Otherwise, a new room is needed for the current meeting
                queue.offer(current);
            }

            // Put the meeting with the updated end time back into the queue
            queue.offer(earliest);
        }

        // The size of the priority queue is the minimum number of rooms required
        return queue.size();
    }

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

