package com.buenosdev;

public class Main {
    public static void main(String[] args) throws StackError {
        var stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
