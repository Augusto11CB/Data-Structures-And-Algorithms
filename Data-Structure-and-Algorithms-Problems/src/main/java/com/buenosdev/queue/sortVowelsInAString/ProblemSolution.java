package com.buenosdev.queue.sortVowelsInAString;

import java.util.PriorityQueue;

class ProblemSolution {
    public String sortVowels(String s) {

        // var map = new TreeMap<Character, Integer>();

        var queue = new PriorityQueue<Character>();

        for (char c : s.toCharArray()) {
            // map.put(c,map.getOrDefault(c, 0) + 1);
            if (!isVowal(c))
                continue;
            queue.offer(c);
        }

        var sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            var cur = s.charAt(i);

            if (!isVowal(cur)) {
                sb.append(cur);
            } else {
                sb.append(queue.poll());
            }
        }
        return sb.toString();
    }

    private boolean isVowal(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}