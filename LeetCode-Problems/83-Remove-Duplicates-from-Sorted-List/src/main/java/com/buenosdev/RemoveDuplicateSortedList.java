package com.buenosdev;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateSortedList {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new LinkedHashSet<>();
        ListNode pointer = head;
        ListNode previousPointer = null;

        while (pointer != null) {
            if (!set.add(pointer.val)) {
                previousPointer.next = pointer.next;
            } else {
                previousPointer = pointer;
            }
            pointer = pointer.next;
        }

        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode list = head;
        while (list.next != null) {
            if (list.val == list.next.val)
                list.next = list.next.next;
            else
                list = list.next;
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
