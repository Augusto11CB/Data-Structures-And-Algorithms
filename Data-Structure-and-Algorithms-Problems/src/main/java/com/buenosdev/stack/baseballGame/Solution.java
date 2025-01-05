package com.buenosdev.stack.baseballGame;

import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        var stack = new Stack<Integer>();
        var resp = 0;

        for (String s : operations) {
            if (s.equals("+")) {
                var firstPop = stack.pop();
                var secondPop = stack.peek();

                stack.push(firstPop);
                stack.push(firstPop + secondPop);

            } else if (s.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        while (!stack.isEmpty()) {
            resp += stack.pop();
        }

        return resp;
    }
}