package com.buenosdev.hashset.jewelsandstones;

import java.util.HashMap;
import java.util.HashSet;

public class ProblemSolution {

    // (HashSet) Problem 2:  Jewels and Stones

    /*
    https://leetcode.com/problems/jewels-and-stones/description/
    **/

    /*
     * */

    public int numJewelsInStones(String jewels, String stones) {
        var jewelsMap = new HashMap<Character, Integer>();

        for (Character c : jewels.toCharArray()) {
            jewelsMap.put(c, 0);
        }

        for (Character c : stones.toCharArray()) {
            if (jewelsMap.containsKey(c)) {
                jewelsMap.put(c, jewelsMap.get(c) + 1);
            }
        }

        return jewelsMap.values().stream().reduce(0, Integer::sum);

    }

       /*
        Time Complexity: O(3n)

        Space Complexity: O(n)

        */


    public int numJewelsInStonesV2(String jewels, String stones) {

        HashSet<Character> jewelCatalog = new HashSet<>();

        // Populate the hashset with jewel types
        for (char c : jewels.toCharArray()) {
            jewelCatalog.add(c);
        }

        int count = 0;
        // Count the number of stones that are jewels
        for (char c : stones.toCharArray()) {
            if (jewelCatalog.contains(c)) {
                count++;
            }
        }

        return count;

    }

       /*
        Time Complexity: O(2n)

        Space Complexity: O(n)
        */

    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution();
        System.out.println(sol.numJewelsInStones("abc", "aabbcc"));  // Expected: 6
        System.out.println(sol.numJewelsInStones("aA", "aAaZz"));    // Expected: 3
        System.out.println(sol.numJewelsInStones("zZ", "zZzZzZ"));   // Expected: 6
    }
}