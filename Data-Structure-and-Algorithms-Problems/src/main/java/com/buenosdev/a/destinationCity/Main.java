package com.buenosdev.a.destinationCity;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        var ps = new ProblemSolutionKt();
        // Test Case 1: Basic Test Case
        List<List<String>> testCase1 = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("B", "C")
        );
        System.out.println("Test Case 1: " + ps.destCity(testCase1)); // Expected Output: "C"

        // Test Case 2: Multiple Routes
        List<List<String>> testCase2 = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("B", "C"),
            Arrays.asList("C", "D")
        );
        System.out.println("Test Case 2: " + ps.destCity(testCase2)); // Expected Output: "D"

        // Test Case 3: Multiple Routes with Same Destination
        List<List<String>> testCase3 = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("B", "C"),
            Arrays.asList("A", "C")
        );
        System.out.println("Test Case 3: " + ps.destCity(testCase3)); // Expected Output: "C"

        // Test Case 4: Multiple Routes with Same Origin
        List<List<String>> testCase4 = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("A", "C"),
            Arrays.asList("A", "D")
        );
        System.out.println("Test Case 4: " + ps.destCity(testCase4)); // Expected Output: "B", "C", or "D"

        // Test Case 5: Empty Input
        List<List<String>> testCase5 = Collections.emptyList();
        System.out.println("Test Case 5: " + ps.destCity(testCase5)); // Expected Output: ""

        // Test Case 6: Single Path with Single City
        List<List<String>> testCase6 = Arrays.asList(
            Arrays.asList("A", "B")
        );
        System.out.println("Test Case 6: " + ps.destCity(testCase6)); // Expected Output: "B"

        // Test Case 7: Single Path with Two Cities
        List<List<String>> testCase7 = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("B", "C"),
            Arrays.asList("C", "D"),
            Arrays.asList("D", "E")
        );
        System.out.println("Test Case 7: " + ps.destCity(testCase7)); // Expected Output: "E"
    }

    
}
