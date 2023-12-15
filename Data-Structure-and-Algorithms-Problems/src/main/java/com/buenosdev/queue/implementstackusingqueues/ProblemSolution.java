package com.buenosdev.queue.implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ProblemSolution {

    // (Queue) Problem 2: Implement Stack using Queues

    /*
    Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

    Implement the MyStack class:
        - void push(int x) Pushes element x to the top of the stack.
        - int pop() Removes the element on the top of the stack and returns it.
        - int top() Returns the element on the top of the stack.
        - boolean empty() Returns true if the stack is empty, false otherwise.

    You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.

     **/

    /*
     * */

    public static void main(String[] args) {
        // Initialize the queue and add some elements to it.
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Call the method to reverse the order of elements in the queue.
        Queue<Integer> result = reverseQueue(queue);

        // Print the reversed queue to the console.
        System.out.println("result: " + result);
        System.out.println("queue: " + queue);
    }

    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> auxQueue = new LinkedList<>();

    private boolean isAuxQueue = false;

    public void push(int x) {
        if (isAuxQueue) {
            auxQueue.add(x);
        } else {
            queue.add(x);
        }
    }

    public int pop() {
        if (isAuxQueue) {
            if (auxQueue.isEmpty()) {
                return -1;
            } else {
                var topStack = -1;
                while (!auxQueue.isEmpty()) {
                    var aux = auxQueue.poll();
                    if (auxQueue.isEmpty()) {
                        topStack = aux;
                    } else {
                        queue.add(aux);
                    }
                }
                isAuxQueue = false;
                return topStack;
            }
        } else {
            if (queue.isEmpty()) {
                return -1;
            } else {
                var topStack = -1;
                while (!queue.isEmpty()) {
                    var aux = queue.poll();
                    if (queue.isEmpty()) {
                        topStack = aux;
                    } else {
                        auxQueue.add(aux);
                    }
                }
                isAuxQueue = true;
                return topStack;
            }
        }
    }

    public int top() {
        if (isAuxQueue) {
            if (auxQueue.isEmpty()) {
                return -1;
            } else {
                var topStack = -1;
                while (!auxQueue.isEmpty()) {
                    var aux = auxQueue.poll();
                    if (auxQueue.isEmpty()) {
                        topStack = aux;
                    }
                    queue.add(aux);
                }
                isAuxQueue = false;
                return topStack;
            }
        } else {
            if (queue.isEmpty()) {
                return -1;
            } else {
                var topStack = -1;
                while (!queue.isEmpty()) {
                    var aux = queue.poll();
                    if (queue.isEmpty()) {
                        topStack = aux;
                    }
                    auxQueue.add(aux);
                }
                isAuxQueue = true;
                return topStack;
            }
        }

    }

    public boolean empty() {
        if (isAuxQueue) {
            return auxQueue.isEmpty();
        } else {
            return queue.isEmpty();
        }
    }

    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        var tmpStack = new Stack<Integer>();

        for (Integer i : q) {
            tmpStack.add(i);
        }

        var response = new LinkedList<Integer>();

        while (!tmpStack.empty()) {
            response.add(tmpStack.pop());
        }

        return response;


        /*
        Time Complexity: O(n)

        Space Complexity: O(1)
        */
    }


}
