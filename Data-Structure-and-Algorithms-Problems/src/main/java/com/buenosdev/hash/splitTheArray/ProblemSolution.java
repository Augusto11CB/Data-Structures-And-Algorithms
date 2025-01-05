package com.buenosdev.hash.splitTheArray;

import java.util.HashMap;

class ProblemSolution {
    public boolean isPossibleToSplit(int[] nums) {

        var hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        for (int i : hashMap.values()) {
            if (i > 2) return false;
        }

        return true;

    }
}