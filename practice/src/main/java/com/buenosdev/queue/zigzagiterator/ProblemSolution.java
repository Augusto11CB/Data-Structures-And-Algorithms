package com.buenosdev.queue.zigzagiterator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ProblemSolution {

    // (Queue) Problem 5: Zigzag Iterator

    /*
    Given two 1d vectors, implement an iterator to return their elements alternately.

    For example, given two 1-d vectors:

    v1 = [1, 2] v2 = [3, 4, 5, 6]

    By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
    **/

    private Queue<Integer> queue;

    public ProblemSolution(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();

        var isV1Enabled = true;

        var v1Runner = 0;
        var v2Runner = 0;

        while (v1Runner < v1.size() && v2Runner < v2.size()) {
            if (isV1Enabled) {
                queue.add(v1.get(v1Runner));
                v1Runner++;
                isV1Enabled = false;
            } else {
                queue.add(v2.get(v2Runner));
                v2Runner++;
                isV1Enabled = true;
            }
        }

        if (v1Runner < v1.size()) {
            for (int i = v1Runner; i < v1.size(); i++) {
                queue.add(v1.get(i));
            }
        } else if (v2Runner < v2.size()) {
            for (int i = v2Runner; i < v2.size(); i++) {
                queue.add(v2.get(i));
            }
        }
        /*
        Time Complexity: O(n+m)
        - n = size v1
        - m = size v2

        Space Complexity: O(n+m)
        */
    }

    public int next() {
        if (queue.isEmpty()) return -1;
        return queue.remove();
    }

    public boolean hasNext() {
        if (queue.isEmpty()) return false;
        return true;
    }
}


