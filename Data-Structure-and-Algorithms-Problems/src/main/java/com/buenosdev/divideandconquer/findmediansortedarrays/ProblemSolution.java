package com.buenosdev.divideandconquer.findmediansortedarrays;

import java.util.HashSet;
import java.util.Set;

public class ProblemSolution {

    /*
     * TODO get link
     * https://www.youtube.com/watch?v=lLFDQCDzfpI
     * */

    public static void main(String[] args) {
        var sol = new ProblemSolution();
        sol.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        var aux = new int[nums1.length + nums2.length];

        doit(nums1, 0, nums2, 0, aux);

        for (int i : aux) {
            System.out.println(i);

        }

        return 2;

    }

    private void doit(int[] nums1, int pos1, int[] nums2, int pos2, int[] aux) {
        if (pos1 == nums1.length - 1 && pos2 == nums2.length - 1) {
            aux[pos1 + pos2] = Math.max(nums1[pos1], nums2[pos2]);
            aux[pos1 + pos2 - 1] = Math.min(nums1[pos1], nums2[pos2]);
            return;
        }

        var newPost1 = getNextPos(nums1, pos1);
        var newPost2 = getNextPos(nums2, pos2);
        doit(nums1, newPost1, nums2, newPost2, aux);
        aux[pos1 + pos2] = Math.max(nums1[pos1], nums2[pos2]);

        aux[pos1 + pos2 - 1] = Math.min(nums1[pos1], nums2[pos2]);
    }

    private int getNextPos(int[] nums, int pos) {
        if (pos >= nums.length - 1) return pos;
        else {
            return pos + 1;
        }
    }

    public String longestNiceSubstring(String s) {
        return getLongestNiceSubstring(s);
    }

    private static String getLongestNiceSubstring(String str) {
        if (str.length() <= 1) {
            return "";
        }

        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            charSet.add(c);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            char upper = Character.toUpperCase(ch);
            char lower = Character.toLowerCase(ch);

            if (!charSet.contains(upper) || !charSet.contains(lower)) {
                // Ignore character in the i position since it does not have any upper || lower case
                //      when doing str.substring(0, i) --> i is not included
                //      when doing str.substring(i + 1) --> i is not included
                String left = getLongestNiceSubstring(str.substring(0, i));
                String right = getLongestNiceSubstring(str.substring(i + 1));

                if (left.length() == right.length()) {
                    return left;
                } else {
                    return left.length() > right.length() ? left : right;
                }
            }
        }

        return str;
    }


}
