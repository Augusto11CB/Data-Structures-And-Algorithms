package com.buenosdev.simplifypath;

import java.util.Stack;

class ProblemSolution {

    // (Stack) Problem 7: Simplify Path

    /*
    Give a string s and convert it into a valid string.
    A string is considered valid if it does not have any two adjacent duplicate characters. The task is to remove the minimum number of characters from s such that it becomes valid. The removal of characters should be done in a way that no further removals are required.
     * */

    /*
    1.
    Input: "/a//b////c/d//././/.."
    Output: "/a/b/c"

    2.
       Input: "/../"
       Output: "/"

    3.
       Input: "/home//foo/"
       Output: "/home/foo"

    4.
       Input: "/home/foo/.."
       Output: "/home/foo"

     * */


    public static void main(String[] args) {
        // Test cases
        System.out.println(simplifyPathV2("/a//b////c/d//././/..")); // Expected output: "/a/b/c"
        System.out.println(simplifyPathV2("/../")); // Expected output: "/"
        System.out.println(simplifyPathV2("/.")); // Expected output: "/"
        System.out.println(simplifyPathV2("/../")); // Expected output: "/"
        System.out.println(simplifyPathV2("/home//foo/")); // Expected output: "/home/foo"
    }


    public static String simplifyPathV2(String path) {
        // this stack tracks the directories
        var tmpStack = new Stack<String>();

        //  split the input path into components by the "/" character
        var pathDirectories = path.split("/");

        for (String directory : pathDirectories) {
            // If the component is "..", pop the top of the stack (if it's not already empty).
            if ("..".equals(directory)) {
                if (!tmpStack.empty()) tmpStack.pop();
            } else if (!directory.isBlank() && !directory.isEmpty() && !directory.equals(".")) {
                tmpStack.add(directory);
            }
        }

        var sb = new StringBuilder();
        while (!tmpStack.empty()) {
            sb.insert(0, "/" + tmpStack.pop());
        }

        var result = sb.toString();

        return result.length() == 0 ? "/" : result.toString();

        /*
        Time Complexity: O(n)

        Space Complexity: O(n)
        */
    }

    public static String simplifyPath(String path) {
        var tmpStack = new Stack<String>();
        for (char i : path.toCharArray()) {
            var iString = String.valueOf(i);
            if (!tmpStack.empty()) {
                var topStack = tmpStack.peek();
                if (topStack.equals("/") && iString.equals(".")) {
                    tmpStack.add(tmpStack.pop() + iString);
                } else if (topStack.equals("/") && iString.equals("/")) {
                    continue;
                } else if (topStack.equals("/.") && iString.equals("/")) {
                    tmpStack.pop();
                } else if (topStack.equals("/.") && iString.equals(".")) {
                    var slashOccurencesControl = 0;
                    while (slashOccurencesControl < 2 && !tmpStack.empty()) {
                        var removedFromTop = tmpStack.pop();
                        if (removedFromTop.equals("/") || removedFromTop.equals("/.")) {
                            slashOccurencesControl = slashOccurencesControl + 1;
                        }
                    }
                } else {
                    tmpStack.add(iString);
                }
            } else {
                tmpStack.add(iString);
            }
        }
        var sb = new StringBuilder();
        while (!tmpStack.empty()) {
            sb.insert(0, tmpStack.pop());
        }

        var result = sb.toString();

        if (result.endsWith("/")) {
            result = result.substring(0, result.length() - 1);
        }

        if (result.equals("")) {
            return "/";
        }

        return result;
    }

}
