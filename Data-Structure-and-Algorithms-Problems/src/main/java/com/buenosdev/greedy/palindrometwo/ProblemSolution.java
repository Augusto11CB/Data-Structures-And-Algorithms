package com.buenosdev.greedy.palindrometwo;

public class ProblemSolution {
    // (Greedy Algorithm) Problem 1: Valid Palindrome II

    /*
    https://leetcode.com/problems/valid-palindrome-ii/description/
     **/

    /*
     * */

    public boolean validPalindrome(String str) {
        var j = str.length() - 1;
        var i = 0;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                var leftResult = isPalindrome(str, i + 1, j);
                var rightResult = isPalindrome(str, i, j - 1);
                return rightResult || leftResult;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindromeFailed(String str) {
        var j = str.length() - 1;
        var i = 0;

        var leftSb = new StringBuilder();
        var rightSb = new StringBuilder();
        var flag = true;

        while (i < j) {
            leftSb.append(str.charAt(i));
            rightSb.append(str.charAt(j));

            if (leftSb.compareTo(rightSb) == 0) {
                i++;
                j--;
                continue;
            }

            if (flag) {
                rightSb.deleteCharAt(rightSb.length() - 1);
                rightSb.append(str.charAt(j - 1));
                if (leftSb.compareTo(rightSb) == 0) {
                    i++;
                    j--;
                    flag = false;
                    continue;
                }

                rightSb.deleteCharAt(rightSb.length() - 1);
                rightSb.append(str.charAt(j));
                leftSb.deleteCharAt(leftSb.length() - 1);
                leftSb.append(str.charAt(i + 1));
                if (leftSb.compareTo(rightSb) != 0) {
                    break;
                } else {
                    i++;
                    j--;
                    flag = false;
                }
            }
        }

        return leftSb.compareTo(rightSb) == 0;
    }

    public static boolean isPalindromePossible(String str) {
        var auxStr = str;
        var reverseAux = new StringBuilder(auxStr).reverse().toString();
        if (auxStr.equals(reverseAux)) return true;


        for (int i = 0; i < str.length(); i++) {
            auxStr = str.replace(String.valueOf(str.charAt(i)), "");

            reverseAux = new StringBuilder(auxStr).reverse().toString();
            if (auxStr.equals(reverseAux)) return true;
        }

        return false;
    }


    public static void main(String[] args) {
        var sol = new ProblemSolution();
        System.out.println(sol.validPalindrome("deeee")); // true
        System.out.println(sol.validPalindrome("abccdba")); // true
        System.out.println(sol.validPalindrome("abcdef"));  // false
    }
}