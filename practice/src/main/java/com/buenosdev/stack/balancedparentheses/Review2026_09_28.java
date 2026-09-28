package com.buenosdev.stack.balancedparentheses;

import java.util.ArrayDeque;

/*
 * https://leetcode.com/problems/valid-parentheses/submissions/2156369024/
 * */

// Valid Parentheses — review date: 2026-09-28
public class Review2026_09_28 {

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;

        var stack = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            var curChar = s.charAt(i);

            var topStack = stack.peek();

            if (topStack == null) {
                stack.push(curChar);
                continue;
            }

            if (isMatchingParentheses(topStack, curChar)) stack.pop();

            else stack.push(curChar);
        }

        return stack.isEmpty();
    }

    private boolean isMatchingParentheses(char p1, char p2) {
        if (p1 == '(' && p2 == ')') return true;
        else if (p1 == '[' && p2 == ']') return true;
        else return p1 == '{' && p2 == '}';
    }
}
