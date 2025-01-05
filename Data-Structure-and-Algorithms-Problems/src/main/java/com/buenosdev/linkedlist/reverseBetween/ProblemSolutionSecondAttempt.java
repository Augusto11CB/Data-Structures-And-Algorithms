package com.buenosdev.linkedlist.reverseBetween;

public class ProblemSolutionSecondAttempt {

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        ListNode previous = null;
        int i = 0;

        // This loop advances current and previous to the nodes at positions left and left - 1, respectively.
        while (current != null && i < left - 1) {
            previous = current;
            current = current.next;
            i++;
        }

        // These lines store the last node of the first part and the first node of the sublist to be reversed.
        var lastFirstPart = previous;
        var lastSubList = current;

        var futureElementInRightPosition = previous;
        ListNode next = null;
        i = 0;

        // This loop reverses the sublist from position left to right.
        while (current != null && i < right - left + 1) {
            next = current.next;
            current.next = previous;
            previous = current;
            futureElementInRightPosition = current;
            current = next;
            i++;
        }

        // These lines connect the reversed sublist with the first part of the list.
        if (lastFirstPart != null) {
            lastFirstPart.next = futureElementInRightPosition;
        } else {
            head = futureElementInRightPosition;
        }

        // This line connects the reversed sublist with the remaining part of the list.
        lastSubList.next = current;

        return head;
    }

}
