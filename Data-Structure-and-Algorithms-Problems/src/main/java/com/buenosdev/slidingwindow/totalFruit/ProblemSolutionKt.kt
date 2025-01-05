package com.buenosdev.slidingwindow.totalFruit

class ProblemSolution {

    /*
    * https://leetcode.com/problems/fruit-into-baskets
    *
    * */

    fun totalFruit(fruits: IntArray): Int {
        var maxAmountOfFruitsSelected = Int.MIN_VALUE
        var windowStart = 0
        val mapOfSelectedFruits = HashMap<Int, Int>()


        for (windowEnd in 0 until fruits.size) {
            mapOfSelectedFruits[fruits[windowEnd]] = mapOfSelectedFruits.getOrDefault(fruits[windowEnd], 0) + 1

            while (mapOfSelectedFruits.size > 2) {
                val fruitToBeRemoved = fruits[windowStart]
                mapOfSelectedFruits[fruitToBeRemoved] = mapOfSelectedFruits[fruitToBeRemoved]!! - 1
                if (mapOfSelectedFruits[fruitToBeRemoved] == 0) mapOfSelectedFruits.remove(fruitToBeRemoved)
                windowStart++
            }

            maxAmountOfFruitsSelected = Math.max(maxAmountOfFruitsSelected, windowEnd - windowStart + (1))
        }

        return maxAmountOfFruitsSelected
    }
}