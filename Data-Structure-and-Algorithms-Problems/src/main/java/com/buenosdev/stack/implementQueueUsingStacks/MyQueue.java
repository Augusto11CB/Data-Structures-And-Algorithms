package com.buenosdev.stack.implementQueueUsingStacks;

import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {

    private Deque<Integer> stack;
    private Deque<Integer> aux;

    public MyQueue() {
        stack = new ArrayDeque<>();
        aux = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);

    }

    public int pop() {
        this.peek();
        return aux.pop();
    }

    public int peek() {
        // var auxStack = new ArrayDeque<Integer>();
        // for(int i = 0; i < stack.size(); i++){
        // auxStack.push(stack.pop());
        // }
        // stack = auxStack;
        // return auxStack.peek();

        if (aux.isEmpty())
            while (!stack.isEmpty())
                aux.push(stack.pop());
        return aux.peek();

    }

    public boolean empty() {

        return stack.isEmpty()
                && aux.isEmpty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */