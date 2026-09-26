package com.buenosdev.greedy.canjumptwo;

public class ProblemSolution {

    // (Greedy Algorithm) Problem G: Jump Game II

    /*
    https://leetcode.com/problems/jump-game/
     **/

    /*
     * */
    public static void main(String[] args) {

        var problemSolution = new ProblemSolution();

//        System.out.println(problemSolution.jump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(problemSolution.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(problemSolution.jump(new int[]{2, 1}));

    }

    public int jump(int[] nums) {
        var counter = 0;
        var r = 0;
        var l = 0;
        var goal = nums.length - 1;

        while (r < goal) {
            var longestJumpPosition = 0;
            for (int i = l; i <= r; i++) {
                longestJumpPosition = Math.max(longestJumpPosition, i + nums[i]);
            }
            l = r + 1;
            r = longestJumpPosition;
            counter = counter + 1;
        }

        return counter;
    }

    public int jumpFAIL2(int[] nums) {
        var goal = nums.length - 1;
        var auxNums = new int[nums.length];

        auxNums[goal] = goal;

        for (int i = goal - 1; i >= 0; i--) {
            var jump = nums[i];
            var isGoal = (jump + i) >= goal;

            if (isGoal) {
                auxNums[i] = goal;
            } else {
                var currentI = auxNums[jump + i];
                if (auxNums[currentI] == goal) {
                    auxNums[i] = jump + i;
                } else {
                    auxNums[i] = -1;
                }

            }
        }
        var count = 0;
        var step = 0;
        while (step != goal) {
            if (auxNums[step] != -1) {
                step = auxNums[auxNums[step]];
                count = count + 1;
            } else {
                step = step + 1;
            }
        }
        return count;
    }

    public int jumpFAIL(int[] nums) {
        var lastP = nums.length - 1;
        var goal = nums.length - 1;

        var auxNums = new int[nums.length];
        auxNums[goal] = goal;

        for (int i = nums.length - 2; i >= 0; i--) {
            var currentP = nums[i];
            if (currentP + i >= lastP) {
                lastP = i;
                auxNums[i] = goal;
            }
        }

        var count = 0;
        var step = 0;
        while (step != goal) {
            if (auxNums[step] != 0) {
                step = auxNums[auxNums[step]];
                if (step == 0) step = step + 1;
                count = count + 1;
            } else {
                step = step + 1;
            }
        }
        return count;
    }
}