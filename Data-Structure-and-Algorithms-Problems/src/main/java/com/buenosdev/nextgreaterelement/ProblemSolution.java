package com.buenosdev.nextgreaterelement;

import java.util.ArrayList;
import java.util.List;

class ProblemSolution {

    // (Stack) Problem 5: Next Greater Element

    /*
    Given an array, print the Next Greater Element (NGE) for every element. The Next Greater Element for an element x is the
    first greater element on the right side of x in the array. Elements for which no greater element exist, consider the next greater element as -1.
     * */

    /*
    Example 1:
    Input: [4, 5, 2, 25]
    Output: [5, 25, 25, -1]

    Example 2:
    Input: [13, 7, 6, 12]
    Output: [-1, 12, 12, -1]

    Example 3:
    Input: [1, 2, 3, 4, 5]
    Output: [2, 3, 4, 5, -1]
     * */

    public static void main(String[] args) {

    }

    public List<Integer> nextLargerElement(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            var currentElement = arr.get(i);
            var nextGreaterElement = -1;
            for (int j = i + 1; j < arr.size(); j++) {
                var nextElement = arr.get(j);
                if (currentElement < nextElement) {
                    nextGreaterElement = nextElement;
                    break;
                }
            }
            res.add(nextGreaterElement);
        }
        return res;
    }

    // TODO - Fazer de uma maneira mais performática, pois está levando O(n²)
}
/*
Time Complexity:
 - O(log(n)): It is O(log(n)) due to the division by 2 at each step.

Space Complexity:
 - O(log(n)): because in each step we will be pushing an element on the stack, and there are a total of O(log(n)) steps.
*/