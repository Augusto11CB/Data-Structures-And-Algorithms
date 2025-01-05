package com.buenosdev.twopointers.sortedsquares

class ProblemSolutionKt {


    // The biggest insight for this algorithm is to take advantage of the fact that the input array is sorted to compute
    // the squares of each element and return a new array with the squared values sorted in ascending order.

    fun sortedSquares(nums: IntArray): IntArray {
        // -4,-1,0,3,10
        var leftP = 0
        var rightP = nums.size - 1
        var slotToInsert = nums.size - 1
        var result = IntArray(nums.size)

        while (leftP < rightP) {
            var leftVal = Math.abs(nums[leftP])
            var rightVal = Math.abs(nums[rightP])
            if (rightVal > leftVal) {
                result[slotToInsert] = rightVal * rightVal
                rightP = rightP - 1
            } else {
                result[slotToInsert] = leftVal * leftVal
                leftP = leftP + 1
            }
            slotToInsert = slotToInsert - 1
        }
        return result

    }

    fun makeSquares(nums: IntArray): IntArray {
        val n = nums.size
        val squares = IntArray(n) // Create an array to store the squared values.
        var highestSquareIdx = n - 1 // Initialize the index to store the highest squared value.
        var left = 0
        var right = nums.size - 1 // Initialize two pointers, one at the beginning and one at the end of the input array.

        // Iterate over the input array from both ends towards the center.
        while (left <= right) {
            val leftSquare = nums[left] * nums[left] // Calculate the square of the value at the left pointer.
            val rightSquare = nums[right] * nums[right] // Calculate the square of the value at the right pointer.
            if (leftSquare > rightSquare) {
                // If the square of the value at the left pointer is greater, store it in the squares array
                // at the current highestSquareIdx and move the left pointer to the right.
                squares[highestSquareIdx--] = leftSquare
                left++
            } else {
                // If the square of the value at the right pointer is greater or equal, store it in the squares array
                // at the current highestSquareIdx and move the right pointer to the left.
                squares[highestSquareIdx--] = rightSquare
                right--
            }
        }
        return squares // Return the sorted array of squared values.
    }
}