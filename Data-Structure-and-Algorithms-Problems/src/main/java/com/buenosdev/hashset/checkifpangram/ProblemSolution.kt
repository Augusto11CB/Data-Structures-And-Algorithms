package com.buenosdev.hashset.checkifpangram

import java.util.*


class ProblemSolution {

    /*
    * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
    * */

    fun checkIfPangram(sentence: String): Boolean {

        var controlArray = IntArray(26)

        for (c in sentence.toCharArray()) {
            val intC = c.code
            if (controlArray[intC] == 1) continue
            else controlArray[intC] = controlArray[intC] + 1

        }

        for (i in controlArray) {
            if (i == 0) return false
        }

        return true
    }

    fun checkIfPangramVar(sentence: String): Boolean {
        val controlArray = IntArray(26)

        for (c in sentence) {
            val index = c - 'a'
            controlArray[index] = 1
        }

        for (i in controlArray) {
            if (i == 0) return false
        }

        return true
    }

    fun main() {
        val sol = ProblemSolution()

        // Test case 1: "TheQuickBrownFoxJumpsOverTheLazyDog"
        // Expected output: true
        println(sol.checkIfPangram("TheQuickBrownFoxJumpsOverTheLazyDog"))

        // Test case 2: "This is not a pangram"
        // Expected output: false
        println(sol.checkIfPangram("This is not a pangram"))

        // Test case 3: "abcdef ghijkl mnopqr stuvwxyz"
        // Expected output: true
        println(sol.checkIfPangram("abcdef ghijkl mnopqr stuvwxyz"))

        // Test case 4: ""
        // Expected output: false
        println(sol.checkIfPangram(""))

        // Test case 5: "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        // Expected output: true
        println(sol.checkIfPangram("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"))
    }

    fun checkIfPangramHashSet(sentence: String): Boolean {
        // Create a set to store unique characters
        val seen: MutableSet<Char> = HashSet()

        // Convert sentence to lowercase and iterate over each character
        for (currChar in sentence.lowercase(Locale.getDefault()).toCharArray()) {
            if (Character.isLetter(currChar)) {
                // Add the character to set
                seen.add(currChar)
            }
        }

        // Return true if set size is 26 (total number of alphabets)
        return seen.size == 26
    }
}