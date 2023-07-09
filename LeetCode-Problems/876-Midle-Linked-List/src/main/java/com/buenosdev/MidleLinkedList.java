package com.buenosdev;

import java.util.ArrayList;

public class MidleLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        System.out.println(middleNode(head).val);
    }

    public static ListNode middleNode(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int length = nodes.size() - 1;
        length = (int) Math.ceil(length / 2.0);
        ListNode node = nodes.get(length);
        return node;
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
