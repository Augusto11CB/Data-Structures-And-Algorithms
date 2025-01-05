package com.buenosdev.general.findtheIndexoftheFirstOccurrenceinaString

class ProblemSolutionKt {
    fun strStr(haystack: String, needle: String): Int {
        if (haystack.length < needle.length) return -1;

        val haystackArray = haystack.toCharArray()

        for (i in 0 until haystackArray.size) {
            if (haystackArray[i] == needle.get(0)) {
                if (checkWord(haystackArray, needle, i)) return i
            }
        }

        return -1
    }

    private fun checkWord(haystack: CharArray, needle: String, wordStart: Int): Boolean {
        if (needle.length > haystack.size - wordStart) return false

        var needlePos = 0

        for (i in wordStart until haystack.size) {
            if (needle.get(needlePos) != haystack[i]) return false
            needlePos++
            if (needlePos == needle.length) break

        }

        return true
    }
}