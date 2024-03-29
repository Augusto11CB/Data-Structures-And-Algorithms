package com.buenosdev.greedy.palindrometwo;

public class ProblemSolutionReviewA {
    /*
    https://leetcode.com/problems/valid-palindrome-ii/description/
    **/

    public static void main(String[] args) {
        var psA = new ProblemSolutionReviewA();
        psA.validPalindrome("abca");
        psA.validPalindrome("aba");
        psA.validPalindrome("abc");
    }

    public Boolean validPalindrome(String s) {
        var j = s.length() - 1;
        var i = 0;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                var excludingCurrentI = isPalindrome(s, i + 1, j);
                var excludingCurrentJ = isPalindrome(s, i, j - 1);

                return excludingCurrentJ || excludingCurrentI;

            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;

            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean validPalindromeFAIL(String s) {
        var i = 0;
        var j = s.length() - 1;

        var sbI = new StringBuilder();
        var sbJ = new StringBuilder();

        var deletionOpUsed = false;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (deletionOpUsed) return false;
                if (s.charAt(i + 1) == s.charAt(j) && !deletionOpUsed && i + 1 < j) {
                    sbI.append(s.charAt(i + 1));
                    sbJ.append(s.charAt(j));
                    deletionOpUsed = true;
                    j = j - 1;
                    i = i + 1 + 1;
                    continue;
                } else if (s.charAt(i) == s.charAt(j - 1) && !deletionOpUsed && j - 1 > i) {
                    sbI.append(s.charAt(i));
                    sbJ.append(s.charAt(j - 1));
                    deletionOpUsed = true;
                    j = j - 1 - 1;
                    i = i + 1;
                    continue;
                }
            }
            sbI.append(s.charAt(i));
            sbJ.append(s.charAt(j));
            j = j - 1;
            i = i + 1;
        }

        return sbI.toString().contentEquals(sbJ);
    }

    public boolean validPalindromeFAIL2(String s) {
        var i = 0;
        var j = s.length() - 1;

        var deletionOpUsed = false;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (deletionOpUsed) return false;
                if (s.charAt(i + 1) == s.charAt(j)) {
                    deletionOpUsed = true;
                    j = j - 1;
                    i = i + 1 + 1;
                } else if (s.charAt(i) == s.charAt(j - 1)) {
                    deletionOpUsed = true;
                    j = j - 1 - 1;
                    i = i + 1;
                }
            } else {
                j = j - 1;
                i = i + 1;
            }
        }

        return true;
    }
}
