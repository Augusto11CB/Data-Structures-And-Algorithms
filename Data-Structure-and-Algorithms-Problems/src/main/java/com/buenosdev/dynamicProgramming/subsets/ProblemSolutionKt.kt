package com.buenosdev.dynamicProgramming.subsets
class ProblemSolutionKt {

    fun subsets(nums: IntArray): List<List<Int>> {
        val res = ArrayList<List<Int>>()
        val subset = ArrayDeque<Int>()
        dfs(nums, 0, subset, res)
        return res
    }

    private fun dfs(nums: IntArray, i: Int, subset: ArrayDeque<Int>, res: ArrayList<List<Int>>) {
        if (i >= nums.size) {
            res.add(subset.toList())
            return
        }
        // decision to include nums[i]
        subset.addLast(nums[i])
        dfs(nums, i + 1, subset, res)
        // decision NOT to include nums[i]
        subset.removeLast()
        dfs(nums, i + 1, subset, res)
    }
}
