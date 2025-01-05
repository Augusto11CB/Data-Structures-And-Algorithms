package com.buenosdev.greedy.sortlist;

public class ProblemSolutionReviewA {

    /*
     * https://leetcode.com/problems/sort-list/description/
     * */


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var fp = head;
        var sp = head;
        var prev = sp;

        while (fp != null && fp.next != null) {
            prev = sp;
            sp = sp.next;
            fp = fp.next.next;
        }

        prev.next = null;

        var leftPart = sortList(head);
        var rightPart = sortList(sp);

        return merge(leftPart, rightPart);

    }

    private ListNode merge(ListNode leftPart, ListNode rightPart) {
        var result = new ListNode(0);
        var aux = result;

        while (leftPart != null && rightPart != null) {
            if (leftPart.val < rightPart.val) {
                aux.next = leftPart;
                leftPart = leftPart.next;
                aux = aux.next;
            } else {
                aux.next = rightPart;
                rightPart = rightPart.next;
                aux = aux.next;
            }
        }
        aux.next = leftPart != null ? leftPart : rightPart;

        return result.next;
    }


    static class ListNode {
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

    public static void main(String[] args) {
        var solution = new ProblemSolutionReviewA();

        // Constructing the linked list for Example 3
        int[] values = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        // Apply the sorting algorithm
        head = solution.sortList(head);

        // Display the sorted list
        System.out.println("Sorted List:");
        printList(head);
    }

    // Helper method to print the list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
