package com.buenosdev.general.binarystringwithsubstringsrepresentingoneton;

import java.util.LinkedList;
import java.util.Queue;

class LeetCode {

    // 1016. Binary String With Substrings Representing 1 To N

    /*
    Given a binary string s and a positive integer n, return true if the binary representation of all the integers in the range [1, n] are substrings of s, or false otherwise.
    A substring is a contiguous sequence of characters within a string.
     **/

    /*
    Example 1:

    Input: s = "0110", n = 3
    Output: true
    Example 2:

    Input: s = "0110", n = 4
    Output: false


    Constraints:

    1 <= s.length <= 1000
    s[i] is either '0' or '1'.
    1 <= n <= 109
     * */

    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String digits = decimalToBinary(i);
            if (!s.contains(digits)) return false;
        }
        return true;
    }

    public static String decimalToBinary(int num) {
        var sb = new StringBuilder();
        var queue = new LinkedList<Integer>();
        var q = num;

        while (q > 0) {
            var reminder = q % 2;
            queue.push(reminder);
            q = Math.floorDiv(q, 2);
        }

        while (!queue.isEmpty()) {
            sb.append(queue.remove());
        }
        return sb.toString();
    }
}
