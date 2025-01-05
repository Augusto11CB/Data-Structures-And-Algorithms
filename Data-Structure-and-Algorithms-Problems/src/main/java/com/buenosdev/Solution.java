package com.buenosdev;
//
//
//import java.util.*;
//
//class Solution {
//
//    public static void main(String[] args) {
//        var resp = frequencySort(new int[]{1, 2, 3, 3,3, 2, 2, 4, 4, 4});
//        for(int i : resp) {
//            System.out.println(i);
//        }
//    }
//    public static int[] frequencySort(int[] nums) {
//        Map<Integer, Integer> freq = new HashMap<>();
//        Arrays.sort(freq, (a, b) -> {
//            if (freq.get(a).equals(freq.get(b))) {
//                return Integer.compare(b, a);
//            }
//            return Integer.compare(freq.get(a), freq.get(b));
//        });
//        var mapOfFreq = new TreeMap<Integer, Pair>();
//
//        for(int num: nums){
//            var pair =  mapOfFreq.getOrDefault(num, new Pair(0, num));
//            pair.freq += 1;
//            mapOfFreq.put(num, pair);
//        }
//
//        // var sortedMap = new TreeMap<Integer, Integer>((a, b) -> mapOfFreq.get(a) - mapOfFreq.get(b));
//        var sortedMap = new PriorityQueue<Pair>(new PairComparartor());
//
//        for(Map.Entry<Integer, Pair> entry : mapOfFreq.entrySet()){
//            sortedMap.add(entry.getValue());
//        }
//
//
//        var result = new int[nums.length];
//        var i = 0;
//        while(sortedMap.size() > 0){
//            var entry = sortedMap.poll();
//            var value = entry.num;
//            var qtd = entry.freq;
//
//            for(var j = 0; j < qtd; j++){
//                result[i] = value;
//                i++;
//            }
//
//        }
//        return result;
//    }
//
//    static class Pair{
//        int freq;
//        int num;
//
//        Pair(int freq, int num){
//            this.freq = freq;
//            this.num = num;
//        }
//    }
//
//    static class PairComparartor implements Comparator<Pair> {
//        @Override
//        public int compare(Pair s1, Pair s2) {
//            if(s1.freq != s2.freq) {
//                return (s1.freq - s2.freq);
//            }
//
//            return s2.num - s1.num;
//        }
//    }
//
//    class StringNumberComparartor implements Comparator<String> {
//        @Override
//        public int compare(String s1, String s2) {
//            if(s1.length() != s2.length()) {
//                return (s1.length() - s2.length());
//            }
//            int len = s1.length();
//            for(int i=0; i<len; i++) {
//                char c1 = s1.charAt(i), c2 = s2.charAt(i);
//                if(c1 == c2) { continue; }
//                return (c1 - c2);
//            }
//            return 0;
//        }
//    }
//
//
//// PriorityQueue<String> pq = new PriorityQueue<>(new StringNumberComparartor());
//}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    // Minimizes the array by replacing pairs with their product
    public int minArrayLength(int[] nums, int k) {
        var ans = new ArrayList<Integer>();
        for(int num : nums) {
            if(num == 0) {
                return 0;
            } else{
                if(!ans.isEmpty() && num * ans.get(ans.size() - 1) <= k) {
                    var product = num * ans.get(ans.size() - 1);
                    ans.set(ans.size() - 1, product);
                } else {
                    ans.add(num);
                }
            }
        }
        return ans.size();
    }

    private List<Integer> dfs(List<Integer> nums, int k) {
        if (nums.size() <= 2) {
            // Handle the base case where the size is 2 or less
            if (nums.size() == 2) {
                int product = nums.get(0) * nums.get(1);
                if (product <= k) {
                    List<Integer> merged = new ArrayList<>();
                    merged.add(product);
                    return merged;
                }
            }
            return new ArrayList<>(nums); // Return the original list if it cannot be merged
        }

        List<Integer> result = new ArrayList<>(nums);
        int minLength = nums.size();

        // Iterate through adjacent pairs
        for (int i = 0; i < nums.size() - 1; i++) {
            int product = nums.get(i) * nums.get(i + 1);

            if (product <= k) {
                // Create a new list after merging the current pair
                List<Integer> newList = new ArrayList<>();
                newList.addAll(nums.subList(0, i)); // Add elements before the pair
                newList.add(product); // Add the merged product
                newList.addAll(nums.subList(i + 2, nums.size())); // Add elements after the pair

                // Recursively find the minimum length for this new list
                List<Integer> candidate = dfs(newList, k);
                if (candidate.size() < minLength) {
                    result = candidate;
                    minLength = candidate.size();
                }
            }
        }

        return result;
    }



    public static void main(String[] args) {
        var obj = new Solution();
        var resp = obj.minArrayLength(new int[]{2, 3, 4, 5}, 10);
        System.out.println(resp);
    }
}