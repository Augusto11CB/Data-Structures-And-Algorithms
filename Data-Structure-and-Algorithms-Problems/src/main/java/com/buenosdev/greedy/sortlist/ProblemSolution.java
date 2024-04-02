package com.buenosdev.greedy.sortlist;

import java.util.Arrays;
import java.util.LinkedList;

public class ProblemSolution {

    /*
     * https://leetcode.com/problems/sort-list/description/
     * */

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var slowPointer = head;
        var fastPointer = head;
        var prevElement = head;
        while (fastPointer != null && fastPointer.next != null) {
            prevElement = slowPointer;
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

        }

        prevElement.next = null;

        var leftSort = sortList(head);
        var rightSort = sortList(slowPointer);

        return merge(leftSort, rightSort);

    }


    private ListNode merge(ListNode listOne, ListNode listTwo) {
        ListNode aux = new ListNode(0);
        ListNode movingPointer = aux;

        while (listOne != null && listTwo != null) {
            // Compare values from each list and append the smaller one
            if (listOne.val < listTwo.val) {
                movingPointer.next = listOne;
                listOne = listOne.next;
            } else {
                movingPointer.next = listTwo;
                listTwo = listTwo.next;
            }
            movingPointer = movingPointer.next;
        }
        // Append any remaining nodes from either list
        movingPointer.next = (listOne != null) ? listOne : listTwo;
        return aux.next; // Return the head of the merged list
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
        var solution = new ProblemSolution();

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
