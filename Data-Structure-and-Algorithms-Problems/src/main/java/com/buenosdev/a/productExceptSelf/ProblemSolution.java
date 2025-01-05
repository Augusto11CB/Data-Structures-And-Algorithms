package com.buenosdev.a.productExceptSelf;

class ProblemSolution {
    public int[] productExceptSelf(int[] nums) {
        Integer allProduct = null;
        var isThereAnyZero = false;
        var moreThanOneZero = false;
        var result = new int[nums.length];

        for (int i : nums) {
            if (i != 0) {
                if (allProduct == null) allProduct = 1;
                allProduct = allProduct * i;
            } else if (isThereAnyZero) {
                moreThanOneZero = true;
            } else {
                isThereAnyZero = true;

            }
        }


        for (int i = 0; i < nums.length; i++) {
            if (moreThanOneZero) {
                result[i] = 0;
            } else if (nums[i] == 0) {
                if (allProduct == null) allProduct = 0;
                result[i] = allProduct;
            } else if (isThereAnyZero) {
                result[i] = 0;
            } else {
                result[i] = allProduct / nums[i];
            }
        }
        return result;
    }
}