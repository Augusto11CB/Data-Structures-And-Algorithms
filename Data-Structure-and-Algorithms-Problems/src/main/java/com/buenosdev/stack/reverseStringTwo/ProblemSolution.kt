package com.buenosdev.stack.reverseStringTwo

import java.util.*

class ProblemSolution {


    /*
    * https://leetcode.com/problems/reverse-string-ii/description/
    * */

    // TODO TRY SECOND ATTEMPT
    fun reverseStr(s: String, k: Int): String {
        val stack = Stack<Char>()

        var kAux = 0
        for (i in s) {

            if (kAux <= k) {
                stack.add(i)
                kAux++
            } else break
        }

        val sb = StringBuilder(s)
        for (i in 0..k) {
            sb.setCharAt(i, stack.pop())
        }

        return sb.toString()
    }

}