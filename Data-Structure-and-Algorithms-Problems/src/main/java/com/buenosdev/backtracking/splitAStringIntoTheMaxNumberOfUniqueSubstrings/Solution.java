package com.buenosdev.backtracking.splitAStringIntoTheMaxNumberOfUniqueSubstrings;

import java.util.*;
class Solution {
    public int maxUniqueSplit(String s) {

        var set = new HashSet<String>();

        return dfs(s, set, 0);
        
    }

    private int dfs(String s, Set<String> set, int start){

        // The dfs function starts with a base case where it returns the size of the set when the current start position is equal to the length of the input string. 
        if(start == s.length()){
            return set.size();
        }

        var mCount = 0;
        for(int i = start + 1; i <= s.length(); i++){
        // If subS is not in the set, the substring is added to the set and the function is recursively called with the new start position being the end of the current substring. This continues until all possible substrings have been processed.
            
            var subS = s.substring(start, i);
            
            if(set.add(subS)){
                mCount = Math.max(mCount, dfs(s, set, i));
                set.remove(subS);
            };
            
        }

        return mCount;

    }
}