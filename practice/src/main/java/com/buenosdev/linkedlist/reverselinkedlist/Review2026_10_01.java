package com.buenosdev.linkedlist.reverselinkedlist;

// https://leetcode.com/problems/reverse-linked-list/
// Reverse Linked List — review date: 2026-10-01
public class Review2026_10_01 {
    public ListNode reverseList(ListNode head) {
        if (head != null && head.next != null) {
            var next = head.next;
            head.next = null;
            return recursion(next, head);

        }
        return head;
    }

    private ListNode recursion(ListNode node, ListNode previous) {
        if (node != null && node.next == null) {
            node.next = previous;
            return node;
        } else {
            var next = node.next;
            node.next = previous;
            return recursion(next, node);
        }

    }
}
