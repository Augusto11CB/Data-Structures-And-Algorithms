package com.buenosdev;

import java.util.Stack;

public class RemoveNthNodeFromLinkedList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode list2 = new ListNode(1, new ListNode(2, null));

        ListNode listNode = removeNthFromEnd(list2, 2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();

        ListNode newHead = head;

        while (newHead != null) {
            stack.add(newHead);
            newHead = newHead.next;
        }

        if (stack.size() == 1) {
            return null;
        }

        for (int i = 1; i < n; i++) {
            stack.pop();
        }

        ListNode toRemove = stack.pop();
        if (stack.isEmpty()) {
            return toRemove.next;
        }
        ListNode prevToNodeToRemove = stack.pop();

        if (prevToNodeToRemove != null && toRemove != null) {
            prevToNodeToRemove.next = toRemove.next;
        }

        return head;

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