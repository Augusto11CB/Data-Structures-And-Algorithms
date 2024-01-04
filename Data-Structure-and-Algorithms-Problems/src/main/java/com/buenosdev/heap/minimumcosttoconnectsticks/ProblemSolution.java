package com.buenosdev.heap.minimumcosttoconnectsticks;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ProblemSolution {

    // (Heap) Problem 3: Minimum Cost to Connect Sticks

    /*
    Given a collection of sticks with different lengths. To combine any two sticks, there's a cost involved, which is equal to the sum of their lengths.

    Connect all the sticks into a single one with the minimum possible cost. Remember, once two sticks are combined, they form a single stick whose length is the sum of the lengths of the two original sticks.
    **/

    /*
    Input: [2, 4, 3]
    Expected Output: 14
    Justification: Combine sticks 2 and 3 for a cost of 5. Now, we have sticks [4,5]. Combine these at a cost of 9. Total cost = 5 + 9 = 14.

    Input: [1, 8, 2, 5]
    Expected Output: 30
    Justification: Combine sticks 1 and 2 for a cost of 3. Now, we have sticks [3, 8, 5]. Combine 3 and 5 for a cost of 8. Now, we have sticks [8,8]. Combine these for a cost of 16. Total cost = 3 + 8 + 16 = 27.

    Input: [5, 5, 5, 5]
    Expected Output: 40
    Justification: Combine two 5s for a cost of 10. Do this again for another cost of 10. Now, we have two sticks of 10 each. Combine these for a cost of 20. Total cost = 10 + 10 + 20 = 40.
     * */

    // The crux of the solution is to always combine the two shortest sticks in the collection. By doing this iteratively until only one stick remains, we can ensure the minimum possible cost.
    public int connectSticks(int[] sticks) {
        int cost = 0;
        var myHeap = new PriorityQueue<Integer>();

        for (int c : sticks) {
            myHeap.add(c);
        }

        while (!myHeap.isEmpty()) {

            var smallestStick = myHeap.poll();

            if (!myHeap.isEmpty()) {
                var secondSmallestStick = myHeap.poll();
                myHeap.add(smallestStick + secondSmallestStick);
                cost = cost + secondSmallestStick + smallestStick;
            } else {
                // After all combinations are complete, we'll be left with just one stick in the heap, which represents the combined length of all original sticks.
                break;
            }
        }

        // The running total we kept during the combination steps represents the minimum cost to connect the sticks.
        return cost;
    }

       /*
        Time Complexity:
        - (1) Converting the array to a heap is O(n*log(n)):
            - one insertion is O(log(n)).
        - (2) Remove & add operations: O(nlogn).
            - Add to heap: O(logn);
            - Remove from heap: O(2 logn) (because we remove 2 elements each iteration from the heap).
            - while iterate n-1 times (because one element remains in the heap).

        Space Complexity: O(n)

        */


    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution();
        System.out.println(sol.connectSticks(new int[]{1, 2, 3, 4})); // Expected: 19
        System.out.println(sol.connectSticks(new int[]{3, 4, 5}));    // Expected: 19
        System.out.println(sol.connectSticks(new int[]{5, 2, 9, 12}));// Expected: 51
    }
}