package com.buenosdev.greedy.canjump;

public class ProblemSolution {

    // (Greedy Algorithm) Problem E: Jump Game

    /*
    https://leetcode.com/problems/jump-game/
     **/

    /*
     * */

// ############################################
//    [ 2, 3, 1, 1, 4 ]
//              cp, lp
//
//    cp = current position
//    lp = goal
// ############################################
//    current position + maximum jump >= goal
//    = 3 + 1 >= 4
//    = true
// ############################################
//    [ 2,  3,  1,  1,  4 ]
//              cp, lp
// ############################################
    public boolean canJump(int[] nums) {
        var lastP = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            var currentP = nums[i];
            if(currentP + i >= lastP) lastP = i;
        }

        return lastP == 0;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)



    public boolean canJumpV2(int[] nums) {

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