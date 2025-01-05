package com.buenosdev.hash.frequencySort

import java.util.*


class Solution {

    /*
    * https://leetcode.com/problems/sort-characters-by-frequency/description/
    * */
    fun frequencySort(s: String): String {

        var hashMap = HashMap<Char, Int>()

        for (i in 0 until s.length) {
            hashMap.put(s[i], hashMap.getOrDefault(s[i], 0) + 1)
        }

        var treeMap = TreeMap<Int, MutableList<Char>>(Collections.reverseOrder())

        for (i in hashMap) {
            var list = treeMap.getOrDefault(i.value, mutableListOf())
            list.add(i.key)
            treeMap.put(i.value, list)
        }

        val sb = StringBuilder()
        for (i in treeMap) {
            val list = i.value
            for (c in list) {
                for (j in 0 until i.key) {
                    sb.append(c)
                }
            }
        }

        return sb.toString()

    }

    fun frequencySortTwo(s: String): String? {
        val hm: MutableMap<Char, Int> = HashMap()
        for (c in s.toCharArray()) {
            hm[c] = hm.getOrDefault(c, 0) + 1
        }

        val pq = PriorityQueue<Map.Entry<Char, Int>> { a, b -> b.value - a.value }

        pq.addAll(hm.entries)

        val result = java.lang.StringBuilder()

        while (!pq.isEmpty()) {
            val (key, value) = pq.poll()
            result.append(key.toString().repeat(value))
        }
        return result.toString()
    }

    fun test() {
        val people = listOf("Alice", "Bob", "Charlie", "Diana");

        val myLambda = {x: Int, y: Int -> x + y}

    }

    fun printProblemCounts(responses: Collection<String>): Int {
        var clientErrors = 0
        var serverErrors = 0
        responses.forEach {
            if (it.startsWith("4")) {
                clientErrors++
            } else if (it.startsWith("5")) {
                serverErrors++
            }
        }
        println("$clientErrors client errors, $serverErrors server errors")
        return serverErrors + clientErrors
    }

    fun main() {
        val responses = listOf("200 OK", "418 I'm a teapot",
            "500 Internal Server Error")
        printProblemCounts(responses)
        // 1 client errors, 1 server errors
    }
}