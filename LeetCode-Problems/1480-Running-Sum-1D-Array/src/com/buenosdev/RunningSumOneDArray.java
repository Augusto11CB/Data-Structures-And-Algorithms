package com.buenosdev;

public class RunningSumOneDArray {
    public static void main(String[] args) {

    }

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                result[i] = nums[i];
            } else{
                result[i] = nums[i] + result[i-1];
            }
        }
        return result;
    }
}