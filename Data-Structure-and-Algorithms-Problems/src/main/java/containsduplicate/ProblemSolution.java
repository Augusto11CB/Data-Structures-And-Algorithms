package containsduplicate;

import java.util.HashSet;

class ProblemSolution {

    // Problem 2: Contains Duplicate


    /*
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every
    element is distinct.
    */

    /*
    Example 1:
    Input: nums= [1, 2, 3, 4]
    Output: false
    Explanation: There are no duplicates in the given array.

    Example 2:
    Input: nums= [1, 2, 3, 1]
    Output: true
    Explanation: '1' is repeating.
     * */

    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(solution.containsDuplicate(nums1)); // Expected output: false

        int[] nums2 = {1, 2, 3, 1};
        System.out.println(solution.containsDuplicate(nums2)); // Expected output: true

        int[] nums3 = {};
        System.out.println(solution.containsDuplicate(nums3)); // Expected output: false

        int[] nums4 = {1, 1, 1, 1};
        System.out.println(solution.containsDuplicate(nums4)); // Expected output: true
    }

    public boolean containsDuplicate(int[] nums) {
        var control = new HashSet();

        for (int x : nums) {
            if (!control.add(x)) // If the set already contains the current element, return true
                return true;
        }
        return false; // Return false if no duplicates found
    }
}

/*
Time Complexity:
 - O(n)

Space Complexity:
 - O(n)
*/