package com.buenosdev.stack.balancedparentheses

import java.util.*

class ProblemSolutionReviewA {

    fun isValid(s: String): Boolean {
        val toCharArray = s.toCharArray()
        val stack = Stack<Char>()

        for (i in toCharArray) {
            if (i == '(' || i == '{' || i == '[') stack.add(i)


            // If stack is empty and we have a closing parenthesis, the string is not balanced
            // Input Example: ')]}'
            if (stack.isEmpty()) {
                return false
            } else if (i == '}') {
                if (stack.peek() != '{') return false
                else stack.pop()
            } else if (i == ')') {
                if (stack.peek() != '(') return false
                else stack.pop()
            } else if (i == ']') {
                if (stack.peek() != '[') return false
                else stack.pop()
            }
        }

        return stack.isEmpty()
    }
}