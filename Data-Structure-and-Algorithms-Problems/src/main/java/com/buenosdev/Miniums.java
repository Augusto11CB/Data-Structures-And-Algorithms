package com.buenosdev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Miniums {
    public List<Integer> miroMiniumQuestion(String command, int d, List<Integer> m) {

        var miniums = new ArrayList<Integer>(m);
        var takenPositions = new HashMap<Integer, Set<Integer>>();
        var directionMinium = new int[command.length()];

        for (int i = 0; i < directionMinium.length; i++) {
            directionMinium[i] = command.charAt(i) == 'R' ? 1 : -1;
            // R == 1;
            // L == -1;
            // I did this way to easily calculate the next position of a minium in line 53;
        }

        for (int i = 0; i < directionMinium.length; i++) {
            var set = takenPositions.getOrDefault(miniums.get(i), new HashSet<Integer>());
            set.add(i);
            takenPositions.put(miniums.get(i), set);
        }

        // this hashset keeps track of the positions with more than one minium;
        var collision = new HashSet<Integer>();

        // this HashSet tells which minium should change position
        var changeDirection = new HashSet<Integer>();
        while (d > 0) {
            checkIfChangeDirection(changeDirection, collision, takenPositions);

            for (int minium = 0; minium < miniums.size(); minium++) {
                if (changeDirection.contains(minium)) {
                    directionMinium[minium] = directionMinium[minium] * -1;
                    changeDirection.remove(minium);

                }
                // remove from the takenPositions map the miniums 'old' position before the 'jump';
                var oldPosition = miniums.get(minium);
                var positionOld = takenPositions.getOrDefault(oldPosition, new HashSet<>());
                positionOld.remove(minium);
                takenPositions.put(oldPosition, positionOld);
                collision.remove(oldPosition);

                // add in the takenPositions map the miniums new position ('jump');
                var jump = miniums.get(minium) + directionMinium[minium];
                var positionJ = takenPositions.getOrDefault(jump, new HashSet<>());
                positionJ.add(minium);
                takenPositions.put(jump, positionJ);
                miniums.set(minium, jump);


                // if more than one minium is in position, mark as collision
                if (positionJ.size() > 1)
                    collision.add(jump);

            }

            d--;
        }
        return miniums;
    }

    private void checkIfChangeDirection(HashSet<Integer> changeDirection, HashSet<Integer> collision, HashMap<Integer, Set<Integer>> takenPositions) {
        for (int idCollision : collision) {
            changeDirection.addAll(takenPositions.get(idCollision));
        }

    }

    public static void main(String[] args) {
        var obj = new Miniums();
        List<Integer> test1 = Arrays.asList(1, 3, 6);
        List<Integer> result1 = obj.miroMiniumQuestion("RLL", 2, test1);
        System.out.println("Test 1 Result: " + result1); // Expected: [2, 3, 4]

        List<Integer> test2 = Arrays.asList(1, 3, 6);
        List<Integer> result2 = obj.miroMiniumQuestion("RRR", 2, test2);
        System.out.println("Test 2 Result: " + result2); // Expected: [1, 3, 1]

        List<Integer> test3 = Arrays.asList(0, 1, 2);
        List<Integer> result3 = obj.miroMiniumQuestion("LRL", 3, test3);
        System.out.println("Test 3 Result: " + result3); // Expected: [-1, 0, 1]

        List<Integer> test4 = Arrays.asList(0, 0, 0);
        List<Integer> result4 = obj.miroMiniumQuestion("RRR", 1, test4);
        System.out.println("Test 4 Result: " + result4); // Expected: [1, 1, 1]

        List<Integer> test5 = Arrays.asList(0, 2, 4);
        List<Integer> result5 = obj.miroMiniumQuestion("RLR", 2, test5);
        System.out.println("Test 5 Result: " + result5); // Expected: [1, 1, 5]
    }
}