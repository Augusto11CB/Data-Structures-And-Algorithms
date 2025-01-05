package com.buenosdev.hash.maximumnumberofballons

class ProblemSolutionReviewAKt {

    fun maxNumberOfBalloonsTwo(text: String): Int {
        if (text.isNullOrBlank() || text.length < 7) return 0
        val hashMap = HashMap<Char, Int>()
        val balloon = "balloon"

        text.forEach { c ->
            if (balloon.contains(c))
                hashMap[c] = hashMap.getOrDefault(c, 0) + 1
        }

        var minCount = Int.MAX_VALUE
        // Calculate the maximum number of times "balloon" can be formed
        minCount = Math.min(minCount, hashMap.getOrDefault('b', 0))
        minCount = Math.min(minCount, hashMap.getOrDefault('a', 0))
        minCount = Math.min(minCount, hashMap.getOrDefault('l', 0) / 2)
        minCount = Math.min(minCount, hashMap.getOrDefault('o', 0) / 2)
        minCount = Math.min(minCount, hashMap.getOrDefault('n', 0))

        return minCount

    }

    fun maxNumberOfBalloons(text: String): Int {
        // balloon
        // 7
        val balloon = "balloon"
        val hashMap = HashMap<Char, Int>()

        for (c in text) {
            if (balloon.contains(c)) hashMap[c] = hashMap.getOrDefault(c, 0) + 1
        }

        balloon.forEach {
            if (!hashMap.contains(it)) return 0
        }

        var result = Int.MAX_VALUE
        for (i in hashMap) {
            var value = i.value
            if (i.key == 'l' || i.key == 'o' && i.value < 2) {
                return 0
            } else if (i.key == 'l' || i.key == 'o' && i.value > 2) {
                value /= 2
            }
            result = Math.min(result, value)
        }

        return result
    }
}