package com.buenosdev.hash.repeatedCharacter

class ProblemSolutionKt {

    /*
    * https://leetcode.com/problems/first-letter-to-appear-twice/description/
    * */

    fun repeatedCharacter(s: String): Char {

        val hash = HashMap<Char, Int>()

        for (i in 0 until s.length) {
            if (hash.containsKey(s[i]) && hash[s[i]]!! >= 1) return s[i]
            else {
                hash[s[i]] = hash.getOrDefault(s[i], 0) + 1
            }
        }

        return '1'

    }
}