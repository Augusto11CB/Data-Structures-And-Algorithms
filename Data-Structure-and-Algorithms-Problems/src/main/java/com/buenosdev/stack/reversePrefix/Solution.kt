package com.buenosdev.stack.reversePrefix

import java.util.*

class Solution {

    /*
    * https://leetcode.com/problems/reverse-prefix-of-word
    * */

    fun reversePrefix(word: String, ch: Char): String {
        val sb = StringBuilder(word)
        val stack = Stack<Char>()
        var isChFound = false

        for (i in 0 until word.length) {
            if (word[i] != ch) stack.add(word[i])
            else if (word[i] == ch) {
                isChFound = true
                stack.add(word[i])
                break
            }
        }

        if (!isChFound && stack.size == word.length) return word

        for (i in 0 until stack.size) {
            sb.set(i, stack.pop())
        }

        return sb.toString()
    }
}