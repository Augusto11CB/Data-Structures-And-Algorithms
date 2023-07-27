package com.buenosdev;

public class RemoveLinkedListElements {

    public static void main(String[] args) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return removeElements(head.next, val);
        return new ListNode(head.val, removeElements(head.next, val));
    }

    public static class ListNode {
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
}