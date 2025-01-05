package com.buenosdev.general.largestThreeSameDigitNumberInString;

import java.util.PriorityQueue;

class ProblemSolution {

    /*
     * https://leetcode.com/problems/largest-3-same-digit-number-in-string/
     * */
    public String largestGoodInteger(String num) {
        if (num == null || num.length() < 3) return "";

        var pq = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int i = 0; i < num.length() - 2; i++) {
            var sb = new StringBuilder("");
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                sb.append(num.charAt(i)).append(num.charAt(i + 1)).append(num.charAt(i + 2));
                pq.add(Integer.valueOf(sb.toString()));
            }
        }
        var result = pq.isEmpty() ? "" : pq.poll().toString();

        return result.equals("0")? "000" : result;
    }

    public String largestGoodIntegerTwo(String num) {
        int result = -1;
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                result = Math.max(result, num.charAt(i) - '0');
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append((char)(48 + result));
        }
        return result == -1 ? "" : builder.toString();
    }
}