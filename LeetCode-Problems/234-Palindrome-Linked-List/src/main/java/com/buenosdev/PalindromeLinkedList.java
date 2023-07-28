package com.buenosdev;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode list2 = new ListNode(1, new ListNode(2));

        System.out.println(isPalindrome(list2));

    }

    public static boolean isPalindrome(ListNode head) {
        ListNode middleNode = middleNodeSecondSolution(head);
        ListNode movingFromMiddle = reverseList(middleNode);
        ListNode movingFromBeginning = head;
        while (movingFromBeginning != middleNode && movingFromMiddle != middleNode) {
            if (movingFromBeginning.val != movingFromMiddle.val) return false;
            movingFromBeginning = movingFromBeginning.next;
            movingFromMiddle = movingFromMiddle.next;
        }

        if (movingFromBeginning.val != movingFromMiddle.val) return false;

        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode aux = head;
        ListNode prev = null;

        while (aux != null) {
            ListNode next = aux.next;
            aux.next = prev;
            prev = aux;
            aux = next;
        }

        return prev;
    }

    public static ListNode middleNodeSecondSolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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