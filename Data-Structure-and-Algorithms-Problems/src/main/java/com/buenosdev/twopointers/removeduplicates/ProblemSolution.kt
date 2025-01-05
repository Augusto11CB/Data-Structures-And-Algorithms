package com.buenosdev.twopointers.removeduplicates

class ProblemSolution {

    /*
    * https://leetcode.com/problems/remove-duplicates-from-sorted-array
    * */

    fun removeDuplicates(nums: IntArray): Int {
        // Initialize a variable to keep track of the position in the array where the next non-duplicate element should be placed.
        var positionAvailableNextToNonDupl = 1

        // Iterate over the array starting from the second element (index 1).
        // Why? because the first element is not duplicated, there is only it!
        for (i in 1 until nums.size) {
            // Get the index of the last non-duplicate element.
            val lastNonDuplElement = positionAvailableNextToNonDupl - 1

            // Check if the current element is different from the last non-duplicate element.
            if (nums[lastNonDuplElement] != nums[i]) {
                // If different, copy the current element to the position next to the last non-duplicate element.
                nums[positionAvailableNextToNonDupl] = nums[i]
                // Increment the index of the positionAvailableNextToNonDupl
                positionAvailableNextToNonDupl = positionAvailableNextToNonDupl + 1
            }
        }

        // como o array é indexado com 0, podemos retornar o positionAvailableNextToNonDupl
        return positionAvailableNextToNonDupl
    }
}