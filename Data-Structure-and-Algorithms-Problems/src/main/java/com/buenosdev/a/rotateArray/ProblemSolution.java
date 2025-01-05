package com.buenosdev.a.rotateArray;

class ProblemSolution {

    // Solution below was based on the solution of hi-malik
    // https://leetcode.com/problems/rotate-array/solutions/1730142/java-c-python-a-very-very-well-detailed-explanation
    public void rotate(int[] nums, int k) {
        // We could use only k if k was not bigger than the length of the array.
        // to handle cases where k is larger than the length of the array use [[[k % nums.length]]]
        var newK = k % nums.length;
        var length = nums.length;

        // 1. Reverse the first part of the array (up to the point where the rotation splits the array).
        // 2. Reverse the second part of the array (from the point where the rotation splits the array to the end).
        // 3. Reverse the entire array to bring the rotated parts into the correct order.

        // Calculate the position where the rotation splits the array.
        // This is the point after which the last newK elements of the array will move to the front.
        var positionWhereRotationSplit = length - newK - 1;

        // Reverse the first part of the array (from index 0 to positionWhereRotationSplit).
        // This reverses the first (length - newK) elements.
        reverse(nums, 0, positionWhereRotationSplit);

        // Reverse the second part of the array (from index positionWhereRotationSplit + 1 to the end of the array).
        // This reverses the last newK elements.
        reverse(nums, positionWhereRotationSplit + 1, length - 1);

        // Reverse the entire array (from index 0 to length - 1).
        // This step combines the two reversed parts into the final rotated order.
        reverse(nums, 0, length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        var i = start;
        var j = end;
        while (i < j) {
            var tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        var s = new ProblemSolution();
        s.rotate(new int[]{-1, -100, 3, 99}, 2);
        s.rotate(new int[]{5, 6, 7, 1, 2, 3, 4}, 4);
    }
}