package com.buenosdev.greedy.haveconflict;

import java.util.Arrays;

public class ProblemSolution {

    /*
    * https://leetcode.com/problems/determine-if-two-events-have-conflict/
    * */

    public boolean haveConflict(String[] event1, String[] event2) {

        var event1End = Integer.valueOf(event1[1].replace(":", ""));
        var event2End = Integer.valueOf(event2[1].replace(":", ""));

        var event2Start = Integer.valueOf(event2[0].replace(":", ""));
        var event1Start = Integer.parseInt(event1[0].replace(":", ""));

        if (event1Start < event2Start) {
            return event1End >= event2Start;
        } else {
            return event2End >= event1Start;
        }
    }
}
