package com.buenosdev.a.findTheDuplicateNumber;

public class ProblemSolution {

    // Floyd's Cycle detection;

    // Move slow one step at a time (slow = slow.next).
    // Move fast two steps at a time (fast = fast.next.next).
    // If slow and fast meet, a cycle is detected.
    // If fast or fast.next becomes null, there is no cycle in the list.
    public int findDuplicate(int[] nums) {
        var fast = 0;
        var slow = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast)
                break;
        }

        
        // The idea behind this approach is that the distance from the head to the start of the cycle is equal to 
        // the distance from the meeting point within the cycle to the start of the cycle. 
        var newSlow = 0;        

        while (newSlow != slow) {
            newSlow = nums[newSlow];
            slow = nums[slow];
        }

        return slow;
    }
}
