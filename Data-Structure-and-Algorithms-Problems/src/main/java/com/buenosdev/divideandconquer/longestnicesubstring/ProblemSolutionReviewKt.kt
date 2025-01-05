package com.buenosdev.divideandconquer.longestnicesubstring


class ProblemSolutionReviewKt {
    // YazaAay

    fun longestNiceSubstring(s: String): String {
        if (s.length <= 1) return ""

        val hashOfChars = HashSet<Char>()

        for (c in s.toCharArray()) {
            hashOfChars.add(c)
        }

        for (i in 0 until s.length) {
            if (!hashOfChars.contains(s[i].lowercaseChar()) || !hashOfChars.contains(s[i].uppercaseChar())) {
                var leftSub = longestNiceSubstring(s.substring(0, i))
                var rightSub = longestNiceSubstring(s.substring(1 + i, s.length))
                return if (leftSub.length > rightSub.length) leftSub else rightSub
            }
        }

        return s
    }
}