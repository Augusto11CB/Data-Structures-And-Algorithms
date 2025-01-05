package com.buenosdev.companiesquestions.uber.examRoom;

import java.util.TreeSet;

class ExamRoom {
    private final int max;
    private final TreeSet<Interval> available;

    private final TreeSet<Integer> taken;

    public ExamRoom(int n) {
        this.max = n - 1;
        this.taken = new TreeSet<>();
        this.available = new TreeSet<>((a, b) -> {
            var distA = getMinDist(a);
            var distB = getMinDist(b);

            return distA == distB ? a.start - b.start : distB - distA;
        });

        this.available.add(new Interval(0, max));

    }


    public int seat() {
        var intervalOfSeatsAvailable = available.pollFirst();

        var indexTaken = getSeatToStudent(intervalOfSeatsAvailable);

        taken.add(indexTaken);

        /*
        * This if statement checks whether there are available seats to the left of the newly assigned seat (indexTaken).
        * It ensures that the left interval is added only if there are seats available between intervalOfSeatsAvailable.start and indexTaken - 1.
        * If this condition is met, it adds a new interval representing the seats from intervalOfSeatsAvailable.start up to indexTaken - 1.
        * */
        if (indexTaken - 1 - intervalOfSeatsAvailable.start >= 0)
            available.add(new Interval(intervalOfSeatsAvailable.start, indexTaken - 1));

        /*
        * This if statement checks whether there are available seats to the right of the newly assigned seat (indexTaken). It ensures that the right interval is added only if there are seats available between indexTaken + 1 and intervalOfSeatsAvailable.end. If this condition is met,
        * it adds a new interval representing the seats from indexTaken + 1 up to intervalOfSeatsAvailable.end.
        * */
        if (intervalOfSeatsAvailable.end - (indexTaken + 1) >= 0)
            available.add(new Interval(indexTaken + 1, intervalOfSeatsAvailable.end));

        return indexTaken;

    }


    public void leave(int p) {
        // Remove the seat index 'p' from the set of taken seats
        taken.remove(p);

        // Find the seat index of the seat just before 'p' in the taken set
        var start = 0;

        // If 'start' is null (meaning there's no seat before 'p'), set 'start' to 0
        if (taken.lower(p) == null) {
            start = 0;
        } else {
            // If there's a seat before 'p', set 'start' to the seat index plus 1
            start = taken.lower(p) + 1;
        }

        // Find the seat index of the seat just after 'p' in the taken set
        var end = 0;

        // If 'end' is null (meaning there's no seat after 'p'), set 'end' to 'max'
        if (taken.higher(p) == null) {
            end = max;
        } else {
            // If there's a seat after 'p', set 'end' to the seat index minus 1
            end = end - 1;
        }

        // Remove the intervals that were created when 'p' was occupied
        // These intervals are [start, p-1] and [p+1, end]
        available.remove(new Interval(start, p - 1));
        available.remove(new Interval(p + 1, end));

        // Add the new interval [start, end] representing the seats that are now available
        available.add(new Interval(start, end));
    }


    private int getMinDist(Interval a) {
        // If the interval 'a' starts at index 0 or ends at 'max',
        // return the length of the interval (end - start)
        if (a.start == 0 || a.end == max)
            return a.end - a.start;
        // Otherwise, calculate the midpoint of the interval
        // by taking half of the interval length and adding it to the start index
        return ((a.end - a.start) / 2) + a.start;
    }


    private int getSeatToStudent(Interval nextSeatAvailable) {
        if (nextSeatAvailable.start == 0) return 0;
        if (nextSeatAvailable.end == max) return max;
        return (nextSeatAvailable.end - nextSeatAvailable.start) / 2;
    }

    private final class Interval {
        private final int start;
        private final int end;

        Interval(int start, int e) {
            this.start = start;
            this.end = e;
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */