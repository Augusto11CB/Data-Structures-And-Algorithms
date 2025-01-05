package com.buenosdev.a.xorOperationInAnArray;

public class ProblemSolution {
    public int xorOperation(int n, int start) {
        var nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + (2 * i);
        }

        var xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }

        return xor;
    }
}
