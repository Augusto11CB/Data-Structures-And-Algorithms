package com.buenosdev.hash.isanagram

class ProblemSolution {

    /*
    * leetcode.com/problems/valid-anagram/
    * */

    fun isAnagram(s: String, t: String): Boolean {

        // Check if the lengths of both strings are equal. If not, return false.
        if (s.length != t.length) {
            return false;
        }

        val hashCharQtd = HashMap<Char, Int>()

        for (c in s.toCharArray()) {
            hashCharQtd.put(c, hashCharQtd.getOrDefault(c, 0) + 1)
        }

        for (c in t.toCharArray()) {
            if (!hashCharQtd.contains(c)) return false
            val newQtd = hashCharQtd.get(c)!!.minus(1)
            if (newQtd <= 0) hashCharQtd.remove(c)
            else hashCharQtd.put(c, newQtd)

        }

        return hashCharQtd.isEmpty()
    }
}