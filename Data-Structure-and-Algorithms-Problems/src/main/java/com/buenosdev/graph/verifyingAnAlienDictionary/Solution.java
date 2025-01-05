package com.buenosdev.graph.verifyingAnAlienDictionary;

import java.util.*;
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        var map = new HashMap<Character, Integer>();

        var position = 1;
        for(char c : order.toCharArray()){
            map.put(c, position);
            position += 1;
        }

        for(int i = 0; i < words.length -1; i++){
            if(!isSorted(words[i], words[i+1], map)) return false;
        }

        return true;
    }

    private boolean isSorted(String wordI, String wordII, Map<Character, Integer> map){

        var wordAr = wordI.toCharArray();

        for(int i = 0; i < wordI.length(); i++){
            if(wordII.length() == i) return false;
            
            var cI = wordI.charAt(i);
            var cII = wordII.charAt(i);
            // According to the rules of lexicographic (dictionary) ordering, this first differing character determines the order of the entire words.
            if(cI != cII){
                // If this condition is true, the method returns false because it means wordI should come after wordII, violating the expected order.
                if(map.get(cI) > map.get(cII)) 
                    return false;
                // Why this break do you ask??
                // When cI is found to be less than cII, the break statement exits the loop. The comment explains that once a valid differing character is found (i.e., cI < cII), there's no need to continue checking the remaining characters. Continuing would be redundant because the order of the words has already been correctly established by the first differing character.
                break;
            }

        }
        return true;
    }
}