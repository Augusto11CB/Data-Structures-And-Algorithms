package com.buenosdev.twopointers.shortestdistance;

class ProblemSolution {

    /*
    * https://aaronice.gitbook.io/lintcode/hash-table/shortest-word-distance
    * */

    public int shortestDistance(String[] words, String word1, String word2) {
        // Initialize the shortest distance with the length of the words list
        int shortestDistance = words.length;
        int position1 = -1, position2 = -1; // Initialize the positions of word1 and word2 with -1

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) { // If the current word is word1, update the position1
                position1 = i;
            } else if (word.equals(word2)) { // If the current word is word2, update the position2
                position2 = i;
            }
            // If both the positions are updated, update the shortest distance
            if (position1 != -1 && position2 != -1) {
                shortestDistance = Math.min(shortestDistance, Math.abs(position1 - position2));
            }
        }
        return shortestDistance;
    }
    public int shortestDistanceFailed(String[] words, String word1, String word2) {

        int word1P = -1;
        int word2P = -1;

        for (int i = 0; i < words.length; i++) {

            if (words[i].equals(word1)) {
                if (word1P < 0) word1P = i;


                if (word2P >= 0 && Math.abs(word2P - i) < Math.abs(word2P - word1P)) {
                    word1P = i;
                }

            }

            if (words[i].equals(word2)) {
                if (word2P < 0) word2P = i;

                if (word1P >= 0 && Math.abs(word1P - i) < Math.abs(word1P - word2P)) {
                    word2P = i;
                }

            }
        }

        return Math.abs(word1P - word2P);
    }

    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();

        // Test case 1
        String[] words1 = { "the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog" };
        String word11 = "fox";
        String word21 = "dog";
        int expectedOutput1 = 5;
        int actualOutput1 = solution.shortestDistance(words1, word11, word21);
        System.out.println("Test case 1: " + (expectedOutput1 == actualOutput1));

        // Test case 2
        String[] words2 = { "a", "b", "c", "d", "a", "b" };
        String word12 = "a";
        String word22 = "b";
        int expectedOutput2 = 1;
        int actualOutput2 = solution.shortestDistance(words2, word12, word22);
        System.out.println("Test case 2: " + (expectedOutput2 == actualOutput2));

        // Test case 3
        String[] words3 = { "a", "c", "d", "b", "a" };
        String word13 = "a";
        String word23 = "b";
        int expectedOutput3 = 1;
        int actualOutput3 = solution.shortestDistance(words3, word13, word23);
        System.out.println("Test case 3: " + (expectedOutput3 == actualOutput3));

        // Test case 4
        String[] words4 = { "a", "b", "c", "d", "e" };
        String word14 = "a";
        String word24 = "e";
        int expectedOutput4 = 4;
        int actualOutput4 = solution.shortestDistance(words4, word14, word24);
        System.out.println("Test case 4: " + (expectedOutput4 == actualOutput4));
    }
}    