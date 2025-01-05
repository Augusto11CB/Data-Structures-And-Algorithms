package com.buenosdev.companiesquestions.uber.findNumberOfLIS

class ProblemSolutionKt {

    fun findNumberOfLIS(nums: IntArray): Int {
        // Create an array 'lis' where lis[i] represents the length of the longest increasing subsequence that ends at index i.
        val lis = IntArray(nums.size) { 1 }
        val countFreq = IntArray(nums.size)

        var maxLenLis = Int.MIN_VALUE
        var resultCounter = 0

        // By starting at the last index, we can easily initialize the base case for our dynamic programming solution. At the last index, the longest increasing subsequence ending at that index is just the element itself, which has a length of 1.
        for (i in nums.size - 1 downTo 0) {
            var maxLenLisLocal = 1;
            var maxCountLocal = 1;
            // For each element at index i, look at all elements to the right of it (index j).
            for (j in i + 1 until nums.size) {

                val previousLisLen = lis[j]
                val previousCountForLISAtSlotJ = countFreq[j]

                if (nums[i] < nums[j]) {

                    if (previousLisLen + 1 > maxLenLisLocal) {
                        maxLenLisLocal = previousLisLen + 1

                        // why we do this assignment???
                        maxCountLocal = previousCountForLISAtSlotJ // Answer: When we find a longer subsequence by including nums[i], all such subsequences ending at j can be extended to end at i.

                    } else if (previousLisLen + 1 == maxLenLisLocal) {
                        maxCountLocal += previousCountForLISAtSlotJ;
                    }

                }
            }

            if (maxLenLisLocal > maxLenLis) {
                maxLenLis = maxLenLisLocal
                resultCounter = maxCountLocal

            } else if (maxLenLisLocal == maxLenLis) {
                resultCounter += maxCountLocal
            }

            lis[i] = maxLenLisLocal
            countFreq[i] = maxCountLocal

        }

        return resultCounter
    }
}