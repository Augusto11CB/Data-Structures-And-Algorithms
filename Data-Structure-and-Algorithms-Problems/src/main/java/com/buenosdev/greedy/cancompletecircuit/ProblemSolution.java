package com.buenosdev.greedy.cancompletecircuit;

class ProblemSolution {

    // (Greedy Algorithm) Problem F: Gas Station

    /*
    https://leetcode.com/problems/gas-station/description/
     **/

    /*
     * */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        var remainingGasTotal = 0;
        var remainingGasLocal = 0;
        var index = 0;

        for (int i = 0; i < gas.length; i++) {
            remainingGasTotal = (remainingGasTotal + gas[i]) - cost[i];

            remainingGasLocal = remainingGasLocal + gas[i] - cost[i];

            // can't complete de circuit using i
            // to to the next i;
            if (remainingGasLocal < 0) {
                remainingGasLocal = 0;
                index = i + 1;
            }
        }

        return remainingGasTotal < 0 ? -1 : index;
    }

    public int canCompleteCircuitFAIL(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            var result = canCompleteCircuitFAIL(gas, cost, i);
            if (result) return i;
        }
        return -1;
    }

    public boolean canCompleteCircuitFAIL(int[] gas, int[] cost, int currentI) {
        int g = gas[currentI];
        int c = cost[currentI];
        if (g < c) return false;

        boolean isCircuit = false;

        var runningI = (currentI + 1) % cost.length;
        while (runningI != currentI) {
            var auxG = g + gas[runningI];
            if (auxG >= c) {
                g = auxG - c;
                c = cost[runningI];
                runningI = (runningI + 1) % cost.length;
                if (runningI == currentI && (g + gas[runningI] >= c)) {
                    isCircuit = true;
                    break;
                }
            } else {
                currentI = runningI;
                g = gas[currentI];
                c = cost[currentI];
                runningI = (runningI + 1) % cost.length;
            }
        }

        return isCircuit;
    }

    public static void main(String[] args) {

        var problemSolution = new ProblemSolution();

//        System.out.println(problemSolution.canCompleteCircuit(new int[]{3, 2, 1}, new int[]{4, 1, 1}));
//        System.out.println(problemSolution.canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
//        System.out.println(problemSolution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));

    }

}