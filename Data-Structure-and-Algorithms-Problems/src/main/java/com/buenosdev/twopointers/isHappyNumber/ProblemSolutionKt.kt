package com.buenosdev.twopointers.isHappyNumber

class ProblemSolutionKt {

    /*
    * https://leetcode.com/problems/happy-number/description/
    * */

//    n = 25
//    (5 ^ 2) = 25
//    (2 ^ 2) + (5 ^ 2) = 4 + 25 = 29
//    (2 ^ 2) + (9 ^ 2) = 4 + 81 = 89 ********************************
//    (8 ^ 2) + (9 ^ 2) = 64 + 81 = 145
//    (1 ^ 2) + (4 ^ 2) + (5 ^ 2) = 42
//    (4 ^ 2) + (2 ^ 2) = 20
//    (2 ^ 2) + (0) = 4
//    (4 ^ 2) = 16
//    (1 ^ 2) + (6 ^ 2) = 37
//    (3 ^ 7) + (7 ^ 2) = 9 + 49 = 58
//    (5 ^ 2) + (8 ^ 2) = 25 + 64 = 89 ********************************
//    (8 ^ 2) + (9 ^ 2) = 64 + 81 = 145
//    ...
//    .....
//    .......
//    ..........
//    it is going to repeat all the operations again

    fun isHappy(n: Int): Boolean {
        val set = HashSet<Int>()
        var num = n
        while (set.add(num)) {
            var aux = num
            var sum = 0
            while (aux > 0) {
                val temp = aux % 10
                sum += temp * temp
                aux /= 10
            }
            if (sum == 1) return true
            else num = sum
        }

        return false
    }

    fun isHappyFastSlow(n: Int): Boolean {

        var slow = n
        var fast = n

        // Initialize slow and fast
        slow = squareOfDigits(slow);
        fast = squareOfDigits(squareOfDigits(fast));

        while (slow != fast) {
            slow = squareOfDigits(slow);
            fast = squareOfDigits(squareOfDigits(fast));
        }


        return false
    }

    private fun squareOfDigits(n: Int): Int {
        var aux = n
        var sum = 0
        while (aux > 0) {
            val temp = aux % 10
            sum += temp * temp
            aux /= 10
        }
        return sum
    }

    fun isHappyFAILED(n: Int): Boolean {
        var stringN = StringBuilder(n)
        var aux = n
        var hashset = HashSet<Int>()

        while (aux != 1) {
            var l = 0
            var r = stringN.length - 1
            var i = 0
            while (l <= r) {
                val intL = stringN[l].code
                val intR = stringN[r].code
                if (l != r) {
                    i += (intL * intL) + (intR * intR)
                } else {
                    i += (intL * intL)
                }
                l += 1
                r -= 1
            }
            if (hashset.contains(i)) {
                return false
            }
            aux = i
            hashset.add(i)
            stringN.setLength(0)
            stringN.append(aux)
        }

        return true
    }
}