package com.buenosdev.implementtwostacksinarray;

public class ProblemSolutionV2 {
    int size;       // Total size of the array
    int top1, top2; // Pointers to track the top elements of two stacks
    int arr[];      // The array to store the elements of the two stacks

    ProblemSolutionV2(int n) {
        arr = new int[n]; // Initialize the array with size 'n'
        size = n;         // Set the total size
        top1 = -1;        // Initialize the top pointer for the first stack to -1 (empty)
        top2 = size;      // Initialize the top pointer for the second stack to 'size' (empty)
    }

    void push1(int x) {
        if (top1 < top2 - 1) {   // Check if there is space in the array for stack 1
            top1++;             // Increment the top pointer for stack 1
            arr[top1] = x;      // Push 'x' onto stack 1
        } else {
            System.out.println("Stack Overflow"); // Display an error message if stack 1 is full
            System.exit(1);                       // Exit the program with an error code
        }
    }

    void push2(int x) {
        if (top1 < top2 - 1) {   // Check if there is space in the array for stack 2
            top2--;             // Decrement the top pointer for stack 2
            arr[top2] = x;      // Push 'x' onto stack 2
        } else {
            System.out.println("Stack Overflow"); // Display an error message if stack 2 is full
            System.exit(1);                       // Exit the program with an error code
        }
    }

    int pop1() {
        if (top1 >= 0) {        // Check if stack 1 is not empty
            int x = arr[top1];  // Get the top element of stack 1
            top1--;             // Decrement the top pointer for stack 1
            return x;           // Return the popped element
        } else {
            System.out.println("Stack Underflow"); // Display an error message if stack 1 is empty
            System.exit(1);                       // Exit the program with an error code
        }
        return 0;
    }

    int pop2() {
        if (top2 < size) {      // Check if stack 2 is not empty
            int x = arr[top2];  // Get the top element of stack 2
            top2++;             // Increment the top pointer for stack 2
            return x;           // Return the popped element
        } else {
            System.out.println("Stack Underflow"); // Display an error message if stack 2 is empty
            System.exit(1);                       // Exit the program with an error code
        }
        return 0;
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
