package com.buenosdev.queue.implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

public class ProblemSolutionV2 {
    private Queue<Integer> main = new LinkedList<Integer>();
    private Queue<Integer> aux = new LinkedList<Integer>();

    public void push(int x) {
        aux.add(x);
        // Move all elements from the main queue to the aux queue,
        // thereby placing the new element at the front of the combined queue (because is first-in-first-out).
        while (!main.isEmpty()) {
            aux.add(main.remove());
        }
        Queue<Integer> temp = main;
        main = aux;
        // Swap the roles of main and aux queues, making the auxiliary queue the new main queue.
        // Therefore aux became the empty queue. :D
        aux = temp;
    }

    public int pop() {
        return main.remove();
    }

    public int top() {
        if (main.isEmpty()) {
            return -1;
        } else {
            return main.peek();
        }
    }

    public boolean empty() {
        return main.isEmpty();
    }
}
