package com.buenosdev.greedy.removekdigits

import java.util.*

open class ProblemSolutionKt {

    fun removeKdigits(num: String, k: Int): String {
        val stack = Stack<Int>()
        var kCopy = k
        var numArray = num.toCharArray().map { it.digitToInt() }.toIntArray()

        for (i in 0 until num.length) {
            while (kCopy > 0 &&
                stack.isNotEmpty() &&
                numArray[i] < stack.peek()
            ) {
                stack.pop()
                kCopy -= 1
            }

            stack.add(numArray[i])
        }

        while (kCopy > 0) {
            stack.pop()
            kCopy--
        }


        val sb = StringBuilder(stack.joinToString(""))

        while (sb.length > 1) {
            if (sb[0].digitToInt() == 0) {
                sb.replace(0, 1, "")
            } else {
                break
            }
        }

        return if (sb.isNullOrBlank()) "0" else sb.toString()
    }
}