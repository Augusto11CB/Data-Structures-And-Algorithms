package com.buenosdev.greedy.minaddtomakevalid;

public class ProblemSolution {

    // (Greedy Algorithm) Problem 3: Minimum Add to Make Parentheses Valid

    /*
    https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
     **/

    /*
     * */

    public int minAddToMakeValidFailed(String s) {
        var sArray = s.toCharArray();
        var leftCounter = 0;
        var rightCounter = 0;
        var result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (sArray[i] == ')') {
                rightCounter = rightCounter + 1;
                if (rightCounter > leftCounter)
                    result = result + 1;


            } else if (sArray[i] == '(') {
                leftCounter = leftCounter + 1;
                if (leftCounter > rightCounter)
                    result = result + 1;
            }
        }

        return result + (Math.abs(rightCounter - leftCounter));
    }

    public static void main(String[] args) {
    }


}