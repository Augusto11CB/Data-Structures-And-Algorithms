package com.buenosdev.queue.zigzagiterator;

import java.util.*;

class ProblemSolutionV2 {
    private Queue<Iterator<Integer>> queue;

    public ProblemSolutionV2(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) queue.add(v1.iterator());
        if (!v2.isEmpty()) queue.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> iter = queue.remove();
        int value = iter.next();
        if (iter.hasNext()) queue.add(iter);
        return value;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        ProblemSolutionV2 i = new ProblemSolutionV2(Arrays.asList(1, 2), Arrays.asList(3, 4, 5, 6));
        System.out.println(i.next());  // returns 1
        System.out.println(i.next());  // returns 3
        System.out.println(i.next());  // returns 2
        System.out.println(i.next());  // returns 4
        System.out.println(i.next());  // returns 5
        System.out.println(i.next());  // returns 6
        System.out.println(i.hasNext());  // returns false
    }

    /*
    - The next() and hasNext() operations have a time complexity of O(1).
    - Space complexity is O(m), where m is the total number of vectors - since each vector is represented as a separate iterator in the deque.
    * */
}