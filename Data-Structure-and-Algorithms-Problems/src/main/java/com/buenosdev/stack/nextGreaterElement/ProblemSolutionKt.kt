package com.buenosdev.stack.nextGreaterElement

import java.util.*


class ProblemSolutionKt {

    /*
    * https://leetcode.com/problems/next-greater-element-i/
    * */
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray? {
        val hash = HashMap<Int, Int?>()
        val result = IntArray(nums1.size)
        // stack utilizada para guardar aquilo que veio antes da gente.
        val stack = Stack<Int>()

        for (i in nums2.indices.reversed()) {
            // stack utilizada para guardar aquilo que veio antes da gente.
            // se aquilo que veio antes da gente é menor do que o meu numero atual, então posso descartar (pop)
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop()
            }
            // quando eu achar aquilo que é antes da gente e é maior, então eu descobri o nextGreater Element
            hash[nums2[i]] = if (stack.empty()) -1 else stack.peek()
            stack.push(nums2[i])
        }
        for (i in nums1.indices) {
            result[i] = if (hash[nums1[i]] != null) hash[nums1[i]]!! else -1
        }
        return result

        // All integers in nums1 and nums2 are unique.
        // Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
    }

    fun nextGreaterElementTwo(nums1: IntArray, nums2: IntArray): IntArray? {
        val result = IntArray(nums1.size)
        val stack = Stack<Int>()
        val map: MutableMap<Int, Int> = HashMap()
        for (num in nums2) {
            while (!stack.isEmpty() && num > stack.peek()) map[stack.pop()] = num
            stack.push(num)
        }
        var i = 0
        for (num in nums1) result[i++] = map.getOrDefault(num, -1)
        return result
    }
}