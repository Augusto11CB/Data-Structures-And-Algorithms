package com.buenosdev.slidingwindow.longestOnes;

class ProblemSolutionReviewA {

        /*
            Consider an array `A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]` and `K = 3`. The longest subarray with ones (either original or flipped from zeros) is of length 10, starting from `A[2]` to `A[11]`.

            As we iterate through the array, we maintain a sliding window of ones. The end of the window (`j`) starts from `A[0]` and moves rightwards. The start of the window (`i`) initially is at `A[0]`.

            When `j = 11` and `i = 2`, we find the longest subarray. In this situation, as we continue to iterate `j`, we also increment `i` in each iteration. This keeps the distance between `j` and `i` constant, maintaining the length of the currently longest subarray.

            However, if we encounter a longer valid subarray (i.e., a subarray with more ones and zeros that can be flipped), the distance between `j` and `i` will increase, leading to a larger window size.

            To visualize this, try appending more 1s to `A`. You'll notice that the window size increases to accommodate the additional 1s, thus finding a larger subarray if one exists.

            In essence, this method uses a sliding window to find the longest subarray with ones. The window size increases when a longer valid subarray is found and remains the same otherwise, effectively iterating through all possible subarrays to find the longest one. This is why we increment both `j` (end of the window) and `i` (start of the window) when the zero counter is below zero, as it allows us to slide the window over the array while maintaining its size. If a larger subarray that meets the condition is found, the window size will increase accordingly. This is the crux of the sliding window approach used in this solution.
        * */

    public int longestOnes(int[] nums, int k) {
        // Initialize the result to the smallest possible integer
        int result = Integer.MIN_VALUE;

        // Initialize the start of the window
        var startW = 0;
        // Initialize the counter for zeros that can be flipped
        var zeroCounter = k;

        // Iterate over the array
        for (int endW = 0; endW < nums.length; endW++) {
            // Decrease the zeroCounter by 1 if the current number is zero (1 - nums[endW] is 1 for zero and 0 for one)
            zeroCounter -= 1 - nums[endW];

            // If zeroCounter is negative, it means we have exhausted our limit to flip zeros to ones
            // So, we move the start of the window to the right until we encounter a zero (which we had flipped earlier)
            // This is why we increment both endW and startW when zeroCounter is below zero
            if (zeroCounter < 0) {
                zeroCounter += 1 - nums[startW];
                startW++;
            }

            // Update the result with the maximum length of subarray with ones (either by flipping or original)
            result = Math.max(result, (endW - startW + 1));
        }

        // Return the length of the longest subarray with ones
        return result;
    }


    public static void main(String[] args) {
        var ps = new ProblemSolutionReviewA();
        var a = new int[]{1, 1, 1, 0, 0, 1, 1, 1, 1};

    }
}