package com.buenosdev.companiesquestions.uber.maximumEmployeesToBeInvitedToAMeeting;

import java.util.*;

public class ProblemSolution {
    // Define a method named maximumInvitations which takes an array of integers as input and returns an integer.
    public int maximumInvitations(int[] A) {
        int n = A.length; // Get the length of the input array A.
        int maxc = 0; // Initialize a variable to store the maximum circle size.
        int[] seen = new int[n]; // Create an array to keep track of whether each person has been visited.

        // Finding the largest circle
        // Loop through each person in the input array.
        for (int idx = 0; idx < n; idx++) {
            if (seen[idx] == 0) { // If the person hasn't been visited yet:
                int start = idx; // Store the index of the starting person.
                int curPeople = idx; // Initialize a variable to keep track of the current person being visited.
                Set<Integer> curSet = new HashSet<>(); // Create a set to store all visited people in the current iteration.

                // Keep visiting new people until we reach a person that has been visited before.
                // When seen[curPeople] == 1, it implies that the current person is not part of a new circle being explored because it has already been encountered before.
                while (seen[curPeople] == 0) {
                    seen[curPeople] = 1; // Mark the current person as visited.
                    curSet.add(curPeople); // Add the current person to the set of visited people.
                    curPeople = A[curPeople]; // Move to the next person based on their favorite.
                }

                // Check if we have found a new circle by checking if the current person is in the set of visited people.

                // If curSet.contains(curPeople) is false, it means that the current person has not been visited in the current iteration,
                // indicating that it's not a part of the current exploration process.
                if (curSet.contains(curPeople)) {
                    int cursum = curSet.size(); // Calculate the size of the current circle.
                    // Adjust the circle size based on the distance from the starting person to the current person.
                    while (start != curPeople) {
                        cursum -= 1;
                        start = A[start];
                    }
                    maxc = Math.max(maxc, cursum); // Update the maximum circle size if necessary.
                }
            }
        }

        // Finding the sum of the largest arms
        List<int[]> pair = new ArrayList<>(); // Create a list to store pairs of people who are mutual favorites.
        int[] visited = new int[n]; // Create an array to keep track of whether each person has been visited in this iteration.
        // Loop through each person in the input array.
        for (int i = 0; i < n; i++) {
            // Check if the current person and their favorite have a mutual favorite relationship and have not been visited yet.
            if (A[A[i]] == i && visited[i] == 0) {
                pair.add(new int[]{i, A[i]}); // Add the pair of people to the list.
                visited[i] = 1; // Mark the current person as visited.
                visited[A[i]] = 1; // Mark their favorite as visited.
            }
        }

        int res = 0; // Initialize a variable to store the result.
        Map<Integer, List<Integer>> child = new HashMap<>(); // Create a map to store the children of each person.
        // Loop through each person in the input array.
        for (int i = 0; i < n; i++) {
            // Add the current person as a child to their favorite in the map.
            child.computeIfAbsent(A[i], k -> new ArrayList<>()).add(i);
        }

        // Loop through each pair of mutual favorite people.
        for (int[] p : pair) {
            int a = p[0]; // Get the first person in the pair.
            int b = p[1]; // Get the second person in the pair.

            // Calculate the maximum arm length starting from person a.
            int maxa = 0; // Initialize a variable to store the maximum arm length.
            Deque<int[]> dq = new ArrayDeque<>(); // Create a deque to perform breadth-first search.
            // Add each child of person a to the deque.
            for (int cand : child.getOrDefault(a, Collections.emptyList())) {
                if (cand != b) {
                    dq.add(new int[]{cand, 1}); // Add the child along with its distance from person a to the deque.
                }
            }
            // Perform breadth-first search to find the maximum arm length.
            while (!dq.isEmpty()) {
                int[] cur = dq.poll(); // Get the current person and their distance from person a from the deque.
                int curNode = cur[0]; // Get the current person.
                int len = cur[1]; // Get the distance from person a.
                maxa = Math.max(maxa, len); // Update the maximum arm length.
                // Add each child of the current person to the deque.
                for (int nxt : child.getOrDefault(curNode, Collections.emptyList())) {
                    dq.add(new int[]{nxt, len + 1}); // Add the child along with its updated distance from person a to the deque.
                }
            }

            // Calculate the maximum arm length starting from person b (similar to the above steps for person a).
            int maxb = 0;
            dq = new ArrayDeque<>();
            for (int cand : child.getOrDefault(b, Collections.emptyList())) {
                if (cand != a) {
                    dq.add(new int[]{cand, 1});
                }
            }
            while (!dq.isEmpty()) {
                int[] cur = dq.poll();
                int curNode = cur[0];
                int len = cur[1];
                maxb = Math.max(maxb, len);
                for (int nxt : child.getOrDefault(curNode, Collections.emptyList())) {
                    dq.add(new int[]{nxt, len + 1});
                }
            }

            // Calculate the total length of the arms and add it to the result.
            res += 2 + maxa + maxb;
        }

        // Return the maximum of the largest circle size and the total arm lengths as the final result.
        return Math.max(maxc, res);
    }

    // Define the main method to test the solution.
    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution(); // Create an instance of the Solution class.
        int[] A = {2, 2, 1, 2}; // Define an example input array.
        System.out.println(sol.maximumInvitations(A)); // Print the result of the maximumInvitations method.
    }
}
