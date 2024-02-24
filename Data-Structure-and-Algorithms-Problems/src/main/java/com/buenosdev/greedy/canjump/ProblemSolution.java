package com.buenosdev.greedy.canjump;

public class ProblemSolution {

    // (Greedy Algorithm) Problem E: Jump Game

    /*
    https://leetcode.com/problems/jump-game/
     **/

    /*
     * */
    public boolean canJump(int[] nums) {

        int currentIndex = 0;

        var nextIndex = nums[0] + 1;

        while (currentIndex < nums.length) {

            if (nextIndex >= nums.length - 1)
                return true;

            var priorToNextIndex = nextIndex - 1;

            while (priorToNextIndex > 0) {
                var indexOfThePriorToNextIndex = nums[priorToNextIndex] + 1 + currentIndex;

                if (indexOfThePriorToNextIndex > nextIndex) nextIndex = indexOfThePriorToNextIndex;

                priorToNextIndex = priorToNextIndex - 1;

            }

            currentIndex = nextIndex;
        }

        return false;

    }

    public static void main(String[] args) {

    }

}