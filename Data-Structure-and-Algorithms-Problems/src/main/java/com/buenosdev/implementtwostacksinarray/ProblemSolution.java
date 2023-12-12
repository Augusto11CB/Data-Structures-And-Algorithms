package com.buenosdev.implementtwostacksinarray;

class ProblemSolution {

    // (Stack) Problem 4:  Implement Two Stacks in an Array

    /*
    Your task is to implement two stacks in a single array efficiently. You need to provide the following methods for
    the stacks: push1, push2, pop1, pop2.
     * */

    /*
    Example 1:
    push1(1)
    push2(2)
    push2(3)
    push1(4)
    pop1() //returns 4
    pop2() //returns 3

    Example 2:
    push2(1)
    push2(2)
    push1(3)
    push2(4)
    pop1() //returns 3
    pop2() //returns 4

    Example 3:
    push1(1)
    push1(2)
    push1(3)
    push2(4)
    pop1() //returns 3
    pop2() //returns 4
     * */

    int size;
    int top1, top2;
    int arr[];

    ProblemSolution(int n) {
        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = arr.length;
    }

    void push1(int x) {
        if (top1 == arr.length - 1 || top1 >= top2 - 1) {
            throw new IndexOutOfBoundsException("Stack is full");
        }
        top1 = top1 + 1;
        arr[top1] = x;
    }

    void push2(int x) {
        if (top2 == 0 || top2 <= top1 + 1) {
            throw new IndexOutOfBoundsException("Stack is full");
        }

        top2 = top2 - 1;
        arr[top2] = x;
    }

    // Note: Always return -1, when stack becomes empty.
    int pop1() {
        if (isEmptyStack1()) {
            return -1;
        }
        int item = arr[top1];
        top1--;
        return item;
    }

    // Note: Always return -1, when stack becomes empty.
    int pop2() {
        if (isEmptyStack2()) {
            return -1;
        }
        int item = arr[top2];
        top2++;
        return item;
    }

    public boolean isEmptyStack1() {
        return top1 == -1;
    }

    public boolean isEmptyStack2() {
        return top2 == arr.length;
    }

    public static void main(String[] args) {
        // Assuming the array has a size of 5
        ProblemSolutionV2 ts = new ProblemSolutionV2(5);

        ts.push1(5);                                 // Push 5 onto stack 1
        ts.push2(10);                                // Push 10 onto stack 2
        ts.push2(15);                                // Push 15 onto stack 2
        ts.push1(11);                                // Push 11 onto stack 1
        ts.push2(7);                                 // Push 7 onto stack 2
        System.out.println("Popped element from stack1 is: " + ts.pop1()); // Pop from stack 1
        ts.push2(40);                                // Push 40 onto stack 2
        System.out.println("Popped element from stack2 is: " + ts.pop2()); // Pop from stack 2
    }
}
