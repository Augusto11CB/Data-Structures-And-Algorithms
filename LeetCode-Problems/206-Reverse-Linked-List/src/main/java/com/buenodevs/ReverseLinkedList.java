package com.buenodevs;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedList = recursiveReverseList(list);

        while (reversedList!= null) {
            System.out.println(reversedList.val);
            reversedList = reversedList.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode aux = head;
        ListNode prev = null;

        while (aux!= null) {
            ListNode next = aux.next;
            aux.next = prev;
            prev = aux;
            aux = next;
        }

        return prev;
    }

    public static ListNode recursiveReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = recursiveReverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
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
