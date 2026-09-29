package com.buenosdev.linkedlist.linkedlistcycle;


// https://leetcode.com/problems/linked-list-cycle/description/

// Linked List Cycle — review date: 2026-09-29
public class Review2026_09_29 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;

        if (head == null || head.next == null) return false;

        ListNode fast = head.next;

        while (slow != null && fast != null) {
            if (slow == fast) return true;

            slow = slow.next;

            if (fast.next == null) return false;
            fast = fast.next.next;
        }

        return false;
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