package com.buenosdev.companiesquestions.uber.longestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit;

import java.util.TreeMap;

class ProblemSolution {

    public int longestSubarray(int[] nums, int limit) {
        var startWindow = 0;
        var result = 0;
        var mapOfFrequences = new TreeMap<Integer, Integer>();

        for (int endWindow = 0; endWindow < nums.length; endWindow++) {
            mapOfFrequences.put(
                    nums[endWindow],
                    mapOfFrequences.getOrDefault(nums[endWindow], 0) + 1
            );

            while (mapOfFrequences.lastKey() - mapOfFrequences.firstKey() > limit) {
                var startWindowElementQtd = mapOfFrequences.get(nums[startWindow]) - 1;
                if (startWindowElementQtd == 0) mapOfFrequences.remove(nums[startWindow]);
                else mapOfFrequences.put(nums[startWindow], startWindowElementQtd);
                startWindow += 1;
            }

            result = Math.max(result, endWindow - startWindow + (1));
        }

        return result;
    }


    /*
     * Time complexity: O(n logn)
     *   Add to the treeMap is O(logn) for each element
     *   Searching the nums[startWindow] in the treeMap is also O(logn) for each element
     *   Removing to the element in the treeMap is also O(logn) for each element (in the case  it might need restructuring to keep it sorted).
     *
     *   Because it is sliding window, we add an element from the array nums exactly one time.
     *   Because it is sliding window, we may remove an element nums[startWindow] exactly one time as well.
     *
     *   Since the for loop iterates over each element in nums once, and the inner while loop only processes each element
     *   once due to the sliding window mechanism, the overall time complexity is O(n log n), where n is the number of
     *   elements in the nums list.
     * */

    public int longestSubarrayFAILED(int[] nums, int limit) {
        var result = 0;
        var startWindow = 0;

        var auxResult = 0;
        var windowEnd = 0;

        while (windowEnd < nums.length) {
            if (!isBellowOrEqualToLimit(nums, startWindow, windowEnd, limit)) {
                result = Math.max(result, auxResult);
                startWindow += 1;
            } else {
                result = Math.max(result, windowEnd - startWindow + 1);
                windowEnd += 1;
            }
        }

        return result;
    }

    private boolean isBellowOrEqualToLimit(int[] nums, int start, int i, int limit) {
        var currentNum = nums[i];
        for (int j = start; j < i; j++) {
            if (Math.abs(nums[j] - currentNum) >= limit) return false;
        }
        return true;
    }
}