package com.buenosdev.stack.simplifypath

import java.util.*

class Solution {

    //  "/home/user/Documents/../Pictures"
    // "/home//foo/"
    // "/.../a/../b/c/../d/./"
    fun simplifyPathFAILED(path: String): String {
        val stack = Stack<String>()

        val pathArray = path.split("/")
            .filter { it.isNotEmpty() }
            .toList()

        for (i in pathArray) {
            if (".." == i) {
                if (stack.isNotEmpty()) stack.pop()
            } else if (".".equals(i)) {
                continue
            } else {
                stack.push(i)
            }
        }

        return "/" + stack.joinToString(separator = "/")
    }

    fun simplifyPath(path: String): String? {
        // this stack tracks the directories
        val tmpStack = Stack<String>()

        //  split the input path into components by the "/" character
        val pathDirectories = path.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (directory in pathDirectories) {
            // If the component is "..", pop the top of the stack (if it's not already empty).
            if (".." == directory) {
                if (!tmpStack.empty()) tmpStack.pop()
            } else if (!directory.isBlank() && !directory.isEmpty() && directory != ".") {
                tmpStack.add(directory)
            }
        }
        val sb = java.lang.StringBuilder()
        while (!tmpStack.empty()) {
            sb.insert(0, "/" + tmpStack.pop())
        }
        val result = sb.toString()
        return if (result.length == 0) "/" else result

        /*
        Time Complexity: O(n)

        Space Complexity: O(n)
        */
    }
}