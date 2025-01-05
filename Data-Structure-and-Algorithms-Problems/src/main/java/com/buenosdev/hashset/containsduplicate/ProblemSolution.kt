package com.buenosdev.hashset.containsduplicate

class ProblemSolution {

    /*
    * https://leetcode.com/problems/contains-duplicate/description/
    * */

    fun containsDuplicate(nums: IntArray): Boolean {

        val controlSet = HashSet<Int>()

        for (i in nums) {
            if (controlSet.contains(i)) return true
            else controlSet.add(i)
        }
        return false
    }
}