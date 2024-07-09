package com.buenosdev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Miniums{
    public List<Integer> miroMiniumQuestion(String command, int d, List<Integer> m) {
        
        var miniums = new ArrayList<Integer>(m);
        var takenPositions = new HashMap<Integer, Set<Integer>>();
        var ar = new int[command.length()];

        for (int i = 0; i < ar.length; i++) {
            ar[i] = command.charAt(i) == 'R' ? 1 : -1;
            // R == 1;
            // L == -1;
            // I did this way to easily calculate the next position of a minium in line 53;
        }

        for (int i = 0; i < ar.length; i++) {
            var set = takenPositions.getOrDefault(miniums.get(i), new HashSet<Integer>());
            set.add(i);
            takenPositions.put(miniums.get(i), set);
        }

        // this hashset keeps track of the positions with more than one minium;
        var collision = new HashSet<Integer>();
        
        // this HashSet tells wich minium should change position
        var changeDirection = new HashSet<Integer>();
        while (d > 0) {
            checkIfChangeDirection(changeDirection, collision, takenPositions);
            
            for (int minium = 0; minium < miniums.size(); minium++) {
                if (changeDirection.contains(minium)) {
                    ar[minium] = ar[minium] * -1;
                    changeDirection.remove(minium);

                } 
                // remove from the takenPositions map the miniums position before the 'jump';
                var oldPosition = miniums.get(minium);
                var positionOld = takenPositions.getOrDefault(oldPosition, new HashSet<>());
                positionOld.remove(minium);
                takenPositions.put(oldPosition, positionOld);
                collision.remove(oldPosition);

                // add in the takenPositions map the miniums position new position ('jump');
                var jump = miniums.get(minium) + ar[minium];
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
}