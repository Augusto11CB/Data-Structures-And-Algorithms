package com.buenosdev.dynamicProgramming.climbStairs;

class ProblemSolution {

    /*
    * https://leetcode.com/problems/climbing-stairs/description/
    * */
    public int climbStairs(int n) {

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
        var solIfITakeOneStepFromWhereIam = 1;
        var solIfITakeTwoStepFromWhereIam = 1;


        for (int i = n - 3; i >= 0; i--) {
            var temp = solIfITakeOneStepFromWhereIam;
            // We calculate the solution for the current step by adding the solutions for the previous two steps.
            solIfITakeOneStepFromWhereIam = solIfITakeOneStepFromWhereIam + solIfITakeTwoStepFromWhereIam;
            solIfITakeTwoStepFromWhereIam = temp;
        }

        return solIfITakeOneStepFromWhereIam;

    }

    public int fib(int n) {
        var end = 1;
        var semiEnd = 1;

        for (int i = n - 3; i >= 0; i--) {
            var temp = end;
            end = end + semiEnd;
            semiEnd = temp;
        }
        return end;
    }
}