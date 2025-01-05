package com.buenosdev.slidingwindow.findmaxaverage;

public class ProblemSolution {

    public static void main(String[] args) {
        var ps = new ProblemSolution();
        ps.findMaxAverage(new int[]{-1}, 1);
    }

    public double findMaxAverage(int[] nums, int k) {
        double result = Double.NEGATIVE_INFINITY;
        double windowSum = 0.0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required
            // window size of 'k'
            if (windowEnd >= k - 1) {
                double aux = windowSum / k; // calculate the average
                if (aux >= result) result = aux;
                windowSum -= nums[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return result;
    }

}
