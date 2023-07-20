package com.buenosdev;

import java.util.HashSet;

public class FindIntersectionTwoLinkedList {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5)))));
        ListNode headB = new ListNode(5, new ListNode(0, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))))));
        ListNode headC = new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))));
        ListNode headD = new ListNode(4, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5)))));
        ListNode headE = new ListNode(5, new ListNode(0, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))))));
        ListNode headF = new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))));
        ListNode headG = new ListNode(4, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5)))));
        ListNode headH = new ListNode(5, new ListNode(0, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))))));
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> st = new HashSet<>();
        while (headA != null) {
            st.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (st.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a.next != null) {
                a = a.next;
            } else {
                a = headB;
            }

            if (b.next != null) {
                b = b.next;
            } else {
                b = headA;
            }
        }
        return a;
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
