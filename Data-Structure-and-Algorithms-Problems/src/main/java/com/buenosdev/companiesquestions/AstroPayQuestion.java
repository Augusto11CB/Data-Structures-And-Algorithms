package com.buenosdev.companiesquestions;

public class AstroPayQuestion {
    public static void main(String[] args) {
        System.out.println("hellow");

        System.out.println(new AstroPayQuestion().solution("011100"));
    }


    /*
    Given a binary number, I need to write a function to count the total steps reaching zero. The rules are:

    If the number is even, divide it by 2
    If the number is odd, subtract 1 from it
    for example, it takes six iterations for "1110" (14) to become 0:

    14 / 2 = 7
    7 - 1 = 6
    6 / 2 = 3
    3 - 1 = 2
    2 / 2 = 1
    1 - 1 = 0

    * */

    // https://stackoverflow.com/questions/55872201/a-function-to-count-the-step-reaching-0
    /*
    Iterate over the characters of S, if the character is a 1, two steps are required, if the character is a 0, only one step is required.

    If there is a 1 at the end, you will subtract 1
    If there is a 0 at the end, you can divide by two and the number will shift to the right.
    The first character is an exception (S[0])
    * */

    /*
    Subtraction: If the last digit is ‘1’, subtract 1 from the binary number. This operation is equivalent to changing the last ‘1’ in the binary string to ‘0’.
    Division: If the last digit is ‘0’, divide the binary number by 2. This operation is equivalent to removing the last ‘0’ from the binary string.
    So, when the character is ‘1’, two steps are required because you first need to subtract 1 to make it ‘0’ (step 1), and then you can divide by 2 to remove the ‘0’ (step 2). Hence, for each ‘1’, you need to perform two operations: subtraction and division, which is why the code adds 2 to the accumulator acc for each ‘1’.

    On the other hand, when the character is ‘0’, only one step is required (division by 2), which is why the code adds 1 to acc for each ‘0’.

    The very first ‘1’ in the string is an exception because you don’t need to perform the division operation after the subtraction, hence acc is decremented by 1 at the end.Subtraction: If the last digit is ‘1’, subtract 1 from the binary number. This operation is equivalent to changing the last ‘1’ in the binary string to ‘0’.
    Division: If the last digit is ‘0’, divide the binary number by 2. This operation is equivalent to removing the last ‘0’ from the binary string.
    So, when the character is ‘1’, two steps are required because you first need to subtract 1 to make it ‘0’ (step 1), and then you can divide by 2 to remove the ‘0’ (step 2). Hence, for each ‘1’, you need to perform two operations: subtraction and division, which is why the code adds 2 to the accumulator acc for each ‘1’.

    On the other hand, when the character is ‘0’, only one step is required (division by 2), which is why the code adds 1 to acc for each ‘0’.

    The very first ‘1’ in the string is an exception because you don’t need to perform the division operation after the subtraction, hence acc is decremented by 1 at the end.
    * */
    public int solution(String s) {
        while (s.charAt(0) == '0') {
            s = s.substring(1);
        }

        int ones = 0;
        int zeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else if (c == '0') {
                zeros++;
            }
        }

        return ((ones * 2) - 1) + zeros;
    }

    public int solutionF2(String s) {
        int i = s.length() - 1, numOperations = 0;
        while (i > 0) {
            numOperations++;
            if (s.charAt(i) == '1') {
                numOperations++;
            }
            i--;
        }

        if (s.charAt(i) == '1')
            numOperations++;

        return numOperations;
    }

    public int solutionF(String S) {
        // Initialize variables
        int v = 0;  // To store the current value
        int operations = 0;  // To count the number of operations

        // Iterate through the binary string
        for (char charValue : S.toCharArray()) {
            // Convert character to integer (using ASCII table)
            int digit = charValue - '0';

            // Update value based on digit
            if (digit == 0) {
                continue;  // Do nothing if it's a 0
            } else if ((v & 1) == 0) {  // Even number (using bitwise AND)
                v >>= 1;  // Divide by 2 (bitwise right shift by 1)
            } else {  // Odd number
                v -= 1;
            }
            operations++;  // Increment operation count
        }

        return operations;
    }
}
