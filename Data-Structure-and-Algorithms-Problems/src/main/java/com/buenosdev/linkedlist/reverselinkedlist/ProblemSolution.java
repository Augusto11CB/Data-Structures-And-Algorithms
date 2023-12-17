package com.buenosdev.linkedlist.reverselinkedlist;

class ProblemSolution {

    // (Linked List) Problem 1: Reverse Linked List

    /*
    Given the head of a singly linked list, your task is to reverse the list and return its head. The singly linked list has nodes, and each node contains an integer and a pointer to the next node. The last node in the list points to null, indicating the end of the list.
    **/

    /*
    Input: [3, 5, 2]
    Expected Output: [2, 5, 3]
    Justification: Reversing the list [3, 5, 2] gives us [2, 5, 3].
     * */


    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();

        // Test case 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(2);
        printList(solution.reverseList(head1)); // Expected Output: 2 5 3

        // Test case 2
        ListNode head2 = new ListNode(7);
        printList(solution.reverseList(head2)); // Expected Output: 7

        // Test case 3
        ListNode head3 = new ListNode(-1);
        head3.next = new ListNode(0);
        head3.next.next = new ListNode(1);
        printList(solution.reverseList(head3)); // Expected Output: 1 0 -1
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    public ListNode reverseList(ListNode head) {
        ListNode aux = head;
        ListNode prev = null;

        while (aux != null) {
            ListNode next = aux.next;
            aux.next = prev;
            prev = aux;
            aux = next;
        }

        return prev;
    }

        /*
        Time Complexity: O(n)

        Space Complexity: O(1)
        */
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}