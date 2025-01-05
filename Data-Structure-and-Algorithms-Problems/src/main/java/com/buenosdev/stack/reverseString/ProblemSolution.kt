package com.buenosdev.stack.reverseString

import java.util.*

class ProblemSolution {

    /*
    * https://leetcode.com/problems/reverse-string
    * */

    fun reverseString(s: CharArray): Unit {
        val stack = Stack<Char>()

        for (i in s) {
            stack.add(i)
        }

        for(i in 0 until stack.size){
            s[i] = stack.pop()
        }
    }
}