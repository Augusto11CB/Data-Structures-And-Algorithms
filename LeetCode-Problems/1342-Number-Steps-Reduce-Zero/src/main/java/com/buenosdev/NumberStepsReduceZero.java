package com.buenosdev;

import java.util.List;

public class NumberStepsReduceZero {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(numberOfSteps(n));
    }


    /*
    Input: num = 14
    Output: 6
    Explanation:
    Step 1) 14 is even; divide by 2 and obtain 7.
    Step 2) 7 is odd; subtract 1 and obtain 6.
    Step 3) 6 is even; divide by 2 and obtain 3.
    Step 4) 3 is odd; subtract 1 and obtain 2.
    Step 5) 2 is even; divide by 2 and obtain 1.
    Step 6) 1 is odd; subtract 1 and obtain 0.
    * */

    public static int numberOfSteps(int num) {
        int result = 0;
        int numAux = num;

        while (numAux > 0) {
            if (numAux % 2 == 0) {
                numAux = Math.floorDiv(numAux, 2);
            } else {
                numAux = numAux - 1;
            }
            result++;
        }
        return result;
    }
}
