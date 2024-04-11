package com.buenosdev.greedy.removekdigits;

import java.util.Stack;

public class ProblemSolution {

    /*
    https://leetcode.com/problems/remove-k-digits
    * */

    public static void main(String[] args) {
        var ps = new ProblemSolution();
        System.out.println(ps.removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {

        var stack = new Stack<Integer>();
        var auxK = k;

        for (int i = 0; i < num.length(); i++) {
            while (auxK > 0 && !stack.isEmpty() && stack.peek() > Character.getNumericValue(num.charAt(i))) {
                stack.pop();
                auxK = auxK - 1;
            }
            stack.add(Character.getNumericValue(num.charAt(i)));
        }

        while (auxK > 0) {
            stack.pop();
            auxK--;
        }

        var sb = new StringBuilder();

        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }

        var resultString = sb.toString();

        // delete leading zeros
        while (resultString.length() > 1 && resultString.charAt(0) == '0')
            resultString = resultString.substring(1);

        return resultString.equals("") ? "0" : resultString;
    }
}
