package com.buenosdev.linkedlist.palindromedoubly;

class ProblemSolution {

    // (Linked List) Problem 4: Find if Doubly Linked List is a Palindrome

    /*
    Given a doubly linked list, determine whether it is a palindrome.

    A doubly linked list is a palindrome if it reads the same backward as forward, utilizing the previous and next pointers of the nodes.
    **/

    /*
    Example 1:
    Input: 1 <-> 2 <-> 3 <-> 2 <-> 1
    Output: true
    Justification: The list reads the same backward as forward.
     * */


    // Main method for testing
    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();
    }


    public boolean isPalindromeV2(DLNode head) {
        if (head == null || head.next == null) return true;

        DLNode tail = head;
        while (tail.next != null) tail = tail.next; // Find the tail of the doubly linked list

        DLNode start = head;
        DLNode end = tail;

        while (start != end && start.prev != end) {
            if (start.val != end.val) return false; // Compare the values at start and end pointers
            start = start.next;
            end = end.prev;
        }

        return true;
    }

    public boolean isPalindrome(DLNode head) {
        var sbWay = new StringBuilder();
        var fakeHead = head;

        while (fakeHead != null && fakeHead.next != null) {
            sbWay.append(fakeHead.val);
            fakeHead = fakeHead.next;
        }

        var firstPath = sbWay.toString();
        sbWay.delete(0, sbWay.length());

        while (fakeHead != null && fakeHead.prev != null) {
            sbWay.append(fakeHead.val);
            fakeHead = fakeHead.prev;
        }
        var secondPath = sbWay.toString();

        return firstPath.equalsIgnoreCase(secondPath);


        /*
        Time Complexity: O(n + m):  `n` and `m` are the lengths of the two input lists

        Space Complexity: O(1)
        */
    }


    class DLNode {
        int val;
        DLNode next, prev;

        DLNode(int val) {
            this.val = val;
        }
    }
}