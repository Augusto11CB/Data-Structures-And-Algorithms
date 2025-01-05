package com.buenosdev.a.missingNumber;

public class ProblemSolution {
    //  if both the bits in comparison are the same XOR returns 0;
    // if we XOR all the numbers in the input array with all numbers from the range 1 to n then each number in the input is going to get zeroed out except the missing number.

    public int missingNumber(int[] nums) {
        var xor1 = 0;
        for(int i = 0; i <= nums.length; i++){
            xor1 = xor1 ^ i;
        }

        var xor2 = 0;
        for (int n: nums){
            xor2 = xor2 ^ n;
        }

        return xor1 ^ xor2;    
    }
}