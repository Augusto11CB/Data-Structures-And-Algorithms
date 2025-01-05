package com.buenosdev.a.singleNumberThree;

class Solution {
    public int[] singleNumber(int[] nums) {
        var xor = 0;

        for(int num : nums){
            xor = xor ^ num;
        }

        var diff = 1;
        
        while(((xor & diff) == 0)){
            diff = diff << 1;
        }

        var a = 0;
        var b = 0;

        for(int num: nums){
            if((num & diff) != 0){
                a = a ^ num;
            } else {
                b = b ^ num;
            }
        }
        
        return new int[]{a,b};
    }
}