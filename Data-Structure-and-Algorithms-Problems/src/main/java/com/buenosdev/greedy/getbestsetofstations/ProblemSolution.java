package com.buenosdev.greedy.getbestsetofstations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProblemSolution {

    // (Greedy Algorithm) Problem I: Hand of Straights

    /*
    https://leetcode.com/problems/hand-of-straights/
     **/

    /*
    Given a set of elements (in this case, states) that need to be covered, and a collection of subsets (in this case, stations) where each subset covers a certain number of elements, the goal is to find the smallest collection of subsets that covers all the elements.
     * */
    /*
    Suppose you’re starting a radio show. You want to reach listeners in all 50 states. You have to decide what stations to play on to reach all those listeners. It costs money to be on each station, so you’re trying to minimize the number of stations you play on. You have a list of stations.
    Each station covers a region, and there’s overlap.
    How do you figure out the smallest set of stations you can play on to cover all 50 states?
     * */
    public static void main(String[] args) {

        var problemSolution = new ProblemSolution();

        Set<String> statesNeeded = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        Map<String, Set<String>> stations = new HashMap<>();
        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

        problemSolution.getBestSetOfStations(statesNeeded, stations);

    }

    public Set<String> getBestSetOfStations(Set<String> statesNeeded, Map<String, Set<String>> stations) {
        Set<String> finalStations = new HashSet<>();

        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();
            for (Map.Entry<String, Set<String>> entry : stations.entrySet()) {
                String station = entry.getKey();
                Set<String> states = entry.getValue();
                Set<String> covered = new HashSet<>(statesNeeded);
                covered.retainAll(states); // COOL FEATURE!!
                if (covered.size() > statesCovered.size()) {
                    bestStation = station;
                    statesCovered = covered;
                }
            }
            statesNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);
        }
        return finalStations;
    }
}