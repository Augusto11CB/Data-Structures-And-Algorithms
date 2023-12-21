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