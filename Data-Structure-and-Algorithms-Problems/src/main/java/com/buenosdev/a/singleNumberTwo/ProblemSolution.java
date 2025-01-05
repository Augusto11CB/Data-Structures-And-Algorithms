package com.buenosdev.a.singleNumberTwo;

class ProblemSolution {
    public int singleNumber(int[] nums) {
        var firstTime = 0;
        var notFirstTime = 0;

        for (final int num : nums) {
            var aux = ~num;
            firstTime = ~notFirstTime & (firstTime ^ num);
            notFirstTime = ~firstTime & (notFirstTime ^ num);
        }

        return firstTime;
    }

    public static void main(String[] args) {
        var ps = new ProblemSolution();
        ps.singleNumber(new int[]{2,2,3,2});
    }
}
/*

    When you perform a bitwise AND operation on -1 and 2, it compares each bit of -1 with the corresponding bit of 2. If both bits are 1, the corresponding result bit is set to 1. Otherwise, the result bit is set to 0.

        So, for “-1 & 2”, the operation is as follows:

        11111111 11111111 11111111 11111111  (binary of -1)
        & 00000000 00000000 00000000 00000010  (binary of 2)
        -----------------------------------
        00000000 00000000 00000000 00000010  (result in binary which is 2 in decimal)

        So, “-1 & 2” returns 2.

*/
