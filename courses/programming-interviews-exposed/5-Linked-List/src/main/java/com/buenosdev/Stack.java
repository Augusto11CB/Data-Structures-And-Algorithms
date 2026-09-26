package com.buenosdev;

/*
 * Stack Implementation
 *
 * Discuss the stack data structure. Implement a stack using either a linked list or a dynamic array,
 * and justify your decision. Design the interface to your stack to be complete, consistent, and easy to use.
 * */

/*
 * - A stack is a last-in-first-out (LIFO)
 * - Stacks are useful data structures for tasks that are divided into multiple subtasks.
 * - Tracking return addresses, parameters, and local variables for subroutines is one example of stack use;
 * tracking tokens when parsing a programming language is another.
 * */
public class Stack<T> {

    private Element<T> head;

    public Stack() {
        this.head = null;
    }

    public T pop() throws StackError {
        if (head == null) {
            throw new StackError(StackErrorType.E_EMPTY);
        }
        var element = head;
        head = head.next();
        return element.val();
    }

    public void push(T data) {
        head = new Element<>(data, head);
    }

    public boolean isEmpty() {
        return head == null;
    }

    enum StackErrorType {
        E_EMPTY("Stack is empty"), E_FULL("Stack is full");

        private final String message;

        private StackErrorType(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }

    class Element<T> {
        private T val;
        private Element<T> next;

        Element() {
        }

        Element(T val) {
            this.val = val;
        }

        Element(T val, Element next) {
            this.val = val;
            this.next = next;
        }

        public T val() {
            return val;
        }


        public Element<T> next() {
            return next;
        }

    }
}

class StackError extends Exception {
    public StackError(Stack.StackErrorType type) {
        super(type.toString());
    }
}

