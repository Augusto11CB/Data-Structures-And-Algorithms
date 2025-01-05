package com.buenosdev.companiesquestions.uber.maximumNumberOfEventsThatCanBeAttended;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class ProblemSolution {

    // What would you do, if you have multiple equally important meetings to run, but can only make some of them? Most
    // people probably would choose to go to the one that is going to end soon. And after that meeting, pick the next
    // meeting from those that are still available.
    public int maxEvents(int[][] events) {
        // count of events attended
        var eventsAttended = 0;

        // Sort events by their ending day
        Arrays.sort(events, Comparator.comparingInt(interval -> interval[1]));

        // Map to store events grouped by their start date
        var mapOfEventsByStartDate = new HashMap<Integer, List<Integer>>();
        // PriorityQueue to keep track of ongoing events that haven't finished
        var onGoingEventsThatDidNotFinished = new PriorityQueue<Integer>();

        // Variables to track the earliest start date and the latest end date of events
        var earliestStartDateEvent = Integer.MAX_VALUE;
        var latestEndDateEvent = 0;

        // Populate the map and update the earliest start date and latest end date
        for (int[] event : events) {
            var list = mapOfEventsByStartDate.getOrDefault(event[0], new ArrayList<>());
            list.add(event[1]);
            mapOfEventsByStartDate.put(event[0], list);

            // Update the earliest start date and latest end date
            earliestStartDateEvent = Math.min(earliestStartDateEvent, event[0]);
            latestEndDateEvent = Math.max(latestEndDateEvent, event[1]);
        }

        // Iterate over each day from the earliest start date to the latest end date
        for (int day = earliestStartDateEvent; day <= latestEndDateEvent; day++) {
            // Remove all events from the priority queue that have already ended by the current day
            while (!onGoingEventsThatDidNotFinished.isEmpty() && onGoingEventsThatDidNotFinished.peek() < day) {
                onGoingEventsThatDidNotFinished.poll();
            }

            // If there are events starting on the current day, add their end dates to the priority queue
            if (mapOfEventsByStartDate.get(day) != null)
                onGoingEventsThatDidNotFinished.addAll(mapOfEventsByStartDate.get(day));

            // If there are ongoing events that haven't finished, attend the one that finishes the earliest
            if (!onGoingEventsThatDidNotFinished.isEmpty()) {
                onGoingEventsThatDidNotFinished.poll();
                eventsAttended += 1; // Increment the count of events attended
            }
        }
        return eventsAttended;
    }

    /*
    Time Complexity: O(nlogn)

        Sorting the events by their ending day: Sorting takes O(n log n) time.

        Populating the map and updating the earliest start date and latest end date: This step involves iterating through all events once, which takes O(n) time.

        Iterating over each day from the earliest start date to the latest end date:
            In the worst case, this loop can run for the range of days from the earliest start to the latest end date, but the operations inside are dominated by the priority queue operations.
            Removing all events from the priority queue that have already ended: Each removal operation takes O(log n), and in the worst case, this can happen n times.
            Adding end dates to the priority queue: Adding elements to the priority queue takes O(log n) time, and in the worst case, this can happen n times.
    * */

    public static void main(String[] args) {
        ProblemSolution problemSolution = new ProblemSolution();

        // Example test case: [[1,2],[2,3],[3,4],[1,2]]
        int[][] events = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};

        // Calling the maxEvents method and printing the result
        int result = problemSolution.maxEvents(events);
        System.out.println("The maximum number of events that can be attended is: " + result);
    }
}