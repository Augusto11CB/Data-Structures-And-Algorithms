package com.buenosdev.linkedlist.swapnodes;

class ProblemSolution {

    // (Linked List) Problem 5: Swap Nodes in Pairs

    /*
    Given a singly linked list, swap every two adjacent nodes and return the head of the modified list.
    If the total number of nodes in the list is odd, the last node remains in place. Every node in the linked list contains a single integer value.
    **/

    /*
    Example 1:
    Input: [7, 8, 9, 10, 11]
    Output: [8, 7, 10, 9, 11]
    Justification: Pairs (7,8) and (9,10) are swapped. 11 remains in its place as it has no adjacent node to swap with.

    Example 2:
    Input: [5, 6]
    Output: [6, 5]
    Justification: The pair (5,6) is swapped
    * */

    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();

        // Initialize the list and perform the swap.
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode newHead = solution.swapPairs(head);
        // Print the list after swapping pairs.
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode movingHead = head;
        head = head.next;
        ListNode prev = null;

        while (movingHead != null) {

            if (movingHead.next != null) {
                ListNode aux = movingHead.next; //C
                movingHead.next = aux.next; // A --> D
                aux.next = movingHead; // C --> A
                // [-->] C --> A --> D
                // [-->] is the prev
                if (prev != null) {
                    prev.next = aux;
                }
            }

            prev = movingHead;
            movingHead = movingHead.next;
        }

        return head;
    }

       /*
        Time Complexity: O(n):

        Space Complexity: O(1)
        */

    public ListNode swapPairsV2(ListNode head) {
        // Initialize a dummy node to maintain the new head of the list after swapping.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // Previous node to maintain the node previous to the current pair being swapped.
        ListNode previous = dummy;

        // Continue swapping until no pairs are left.
        while (head != null && head.next != null) {
            // Initialize the first and second nodes of the pair to be swapped.
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Adjust the pointers to perform the swap.
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            previous.next = secondNode;

            // Move to the next pair.
            head = firstNode.next;
            previous = firstNode;
        }
        // Return the new head of the list after swapping.
        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}