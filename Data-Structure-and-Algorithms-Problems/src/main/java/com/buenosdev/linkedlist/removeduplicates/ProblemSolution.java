package com.buenosdev.linkedlist.removeduplicates;

class ProblemSolution {

    // (Linked List) Problem 2: Remove Duplicates from Sorted List

    /*
    Given a sorted linked list, remove all the duplicate elements to leave only distinct numbers. The linked list should remain sorted, and the modified list should be returned.
    **/

    /*
    Input: 1 -> 2 -> 2 -> 3
    Output: 1 -> 2 -> 3
    Justification: Here, 2 is the duplicate element, and by removing it, we obtain a list containing only distinct elements.
     * */


    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();

        // Test Example 1
        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode result1 = solution.deleteDuplicates(head1); // Expected: 1 -> 2
        solution.printList(result1);

        // Test Example 2
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));
        ListNode result2 = solution.deleteDuplicates(head2); // Expected: 1 -> 2 -> 3
        solution.printList(result2);

        // Test Example 3
        ListNode head3 = new ListNode(3, new ListNode(3, new ListNode(3)));
        ListNode result3 = solution.deleteDuplicates(head3); // Expected: 3
        solution.printList(result3);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode aux = head;

        while (aux != null && aux.next != null) {
            if (aux.val == aux.next.val) {
                if (aux.next.next != null) {
                    aux.next = aux.next.next;
                } else {
                    aux.next = null;
                }
            } else {
                aux = aux.next;
            }
        }
        return head;
    }

        /*
        Time Complexity: O(n)

        Space Complexity: O(1)
        */
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