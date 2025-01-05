package com.buenosdev.hash.frequencySort;

import java.util.ArrayList;

public class Exec {
    public static void main(String[] args) {
        var solution = new Solution();

        var responses = new ArrayList<String>();
        responses.add("200 OK");
        responses.add("418 I'm a teapot");
        responses.add("500 Internal Server Error");
        responses.add("500 Internal Server Error");

        System.out.println(solution.printProblemCounts(responses));
    }
}
