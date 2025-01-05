package com.buenosdev.stack.nextGreaterElements

import java.util.*

class ProblemSolutionKt {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        val stack = Stack<Int>()

        for (num in nums.size - 1 downTo 0) stack.add(nums[num])

        for (i in nums.size - 1 downTo 0) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop()
            }

            result[i] = if (stack.empty()) -1 else stack.peek()
            stack.push(nums[i])
        }

        return result
    }
}