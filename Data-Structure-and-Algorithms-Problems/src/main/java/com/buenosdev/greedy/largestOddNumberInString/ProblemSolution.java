package com.buenosdev.greedy.largestOddNumberInString;

class ProblemSolution {

    /*
    * https://leetcode.com/problems/largest-odd-number-in-string/
    * */

    // A number is odd if and only if its rightmost digit is odd.
    public String largestOddNumber(String num) {
        if (num == null || num.isBlank()) return "";

        int n = num.length() - 1;
        while (n >= 0 && (num.charAt(n) - '0') % 2 == 0) {
            n--;
        }
        return n >= 0 ? num.substring(0, n + 1) : "";
    }


    public static void main(String[] args) {
        var solution = new ProblemSolution();
        System.out.println(solution.largestOddNumber("52"));
    }
}