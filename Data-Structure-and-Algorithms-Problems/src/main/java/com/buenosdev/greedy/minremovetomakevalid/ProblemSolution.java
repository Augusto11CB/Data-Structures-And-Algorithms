package com.buenosdev.greedy.minremovetomakevalid;

public class ProblemSolution {

    // (Greedy Algorithm) Problem C: Minimum Remove to Make Valid Parentheses

    /*
    https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
     **/

    /*
     * */

    public String minRemoveToMakeValid(String s) {
        var sArray = s.toCharArray();
        var leftCounter = 0;
        var rightCounter = 0;
        var sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (sArray[i] == '(') {
                leftCounter = leftCounter + 1;
                sb.append(sArray[i]);
            } else if (sArray[i] == ')') {
                if (leftCounter > rightCounter) {
                    rightCounter = rightCounter + 1;
                    sb.append(sArray[i]);
                }
            } else {
                sb.append(sArray[i]);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
    }


}