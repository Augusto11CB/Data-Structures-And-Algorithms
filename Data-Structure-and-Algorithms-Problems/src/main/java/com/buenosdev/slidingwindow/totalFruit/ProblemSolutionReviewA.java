package com.buenosdev.slidingwindow.totalFruit;

import java.util.HashMap;

public class ProblemSolutionReviewA {

    public int totalFruit(int[] fruits) {
        int result = Integer.MIN_VALUE;
        int windowStart = 0;
        var hashMap = new HashMap<Integer, Integer>();

        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            hashMap.put(fruits[windowEnd], hashMap.getOrDefault(fruits[windowEnd], 0) + 1);

            while (hashMap.size() > 2) {
                int fruitToBeRemoved = fruits[windowStart];
                hashMap.put(fruitToBeRemoved, hashMap.get(fruitToBeRemoved) - 1);
                if (hashMap.get(fruitToBeRemoved) == 0) hashMap.remove(fruitToBeRemoved);
                windowStart++;
            }

            result = Math.max(result, windowEnd - windowStart + 1);
        }

        return result;
    }

    public int totalFruitFAILED(int[] fruits) {
        var result = 0;
        var resultAux = 0;
        var hashMap = new HashMap<Integer, Integer>();
        var startWindow = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (hashMap.containsKey(fruits[i])) {
                resultAux += 1;
                hashMap.put(fruits[i], hashMap.get(fruits[i]) + 1);
            } else if (!hashMap.containsKey(fruits[i]) && hashMap.size() < 2) {
                resultAux += 1;
                hashMap.put(fruits[i], 1);
            } else {
                var newQntFSW = hashMap.get(fruits[startWindow]) - 1;
                if (newQntFSW == 0) {
                    hashMap.remove(fruits[startWindow]);
                } else {
                    hashMap.put(fruits[startWindow], newQntFSW);
                }
                startWindow += 1;
            }
            result = Math.max(resultAux, result);
        }

        return result;

    }
}
