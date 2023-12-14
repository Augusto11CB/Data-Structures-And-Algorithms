package com.buenosdev.makestringgreat;

import java.util.Stack;

class ProblemSolution {

    // (Stack) Problem 10: Make The String Great

    /*
    Given a string of English lowercase and uppercase letters, make the string "good" by removing two adjacent characters that are the same but in different cases.
    Continue to do this until there are no more adjacent characters of the same letter but in different cases. An empty string is also considered "good".
    **/

    /*
    Example 1
    Input: "AaBbCcDdEeff"
    Output: "ff"
    Explanation: In the first step, "AaBbCcDdEeff" becomes "BbcCDdEeff" because 'A' and 'a' are the same letter, but one is uppercase and the other is lowercase. Then we remove "Bb", and then "cC", "dD", and "Ee". In the end we are left with "ff" which we can't remove - although both characters are the same but with the same case.

    Example 2
    Input: "abBA"
    Output: ""
    Explanation: In the first step, "abBA" becomes "aA" because 'b' and 'B' are the same letter, but one is uppercase and the other is lowercase. Then "aA" becomes "" for the same reason. The final string is empty, which is good.

    Example 3
    Input: "s"
    Output: "s"
    Explanation: The string "s" is already good because it only contains one character.
     * */


    public static void main(String[] args) {
        String one = "a";
        String two = "A";
        // topStack.equalsIgnoreCase(charString) && !topStack.equals(charString)

        System.out.println(one.equalsIgnoreCase(two));
        System.out.println(one.equals(two));
        System.out.println(one.equalsIgnoreCase(two) && !one.equals(two));
    }

    public String makeGood(String str) {
        var tmpStack = new Stack<Character>();
        for (Character character : str.toCharArray()) {

            if (!tmpStack.empty()
                    && Character.toLowerCase(tmpStack.peek()) == Character.toLowerCase(character)
                    && !tmpStack.peek().equals(character)
            ) {
                // If the conditions are met, pop the character from the stack,
                // effectively removing the pair of characters.
                tmpStack.pop();
            } else {
                tmpStack.add(character);
            }
        }

        var sb = new StringBuilder();
        while (!tmpStack.empty()) {
            sb.insert(0, tmpStack.pop());
        }

        return sb.toString();

        /*
        Time Complexity: O(n)
        - This is because it is performed a single pass over the string.

        Space Complexity: O(n)
        -   In the worst case, if the string is already good, the stack will contain all the characters of the string.
        */
    }


}
