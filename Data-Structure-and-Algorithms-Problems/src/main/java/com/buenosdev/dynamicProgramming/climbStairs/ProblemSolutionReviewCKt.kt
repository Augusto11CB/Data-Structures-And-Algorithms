package com.buenosdev.dynamicProgramming.climbStairs

class ProblemSolutionReviewCKt {
    fun climbStairs(n: Int): Int {

        // involves two key concepts: memoization and bottom-up computation.
        // Memoization: We store the solutions of subproblems to avoid redundant calculations.
        // Bottom-up computation: We start from the base case and build up the solution for the problem.

        // n = 1 --> there is only one way to achieve this step
        // n-1 = 1 --> there is only one way from this step we reach the last step 'n'
        // n-2 = (n-1) + (n)
        // n-3 = (n-2) + (n-1)
        // n-4 = (n-3) + (n-2)
        // ....

        // We initialize the solutions for the first step and the second step.

        if (n == 1) return 1;
        if (n == 2) return 2;

        val cachePreviusStepsTaken = IntArray(n + 1)

        cachePreviusStepsTaken[n] = 1
        cachePreviusStepsTaken[n - 1] = 1

        for (i in n - 2 downTo 0) {
            cachePreviusStepsTaken[i] = (cachePreviusStepsTaken[i + 1] + cachePreviusStepsTaken[i + 2])
        }

        return cachePreviusStepsTaken[0]
    }
}