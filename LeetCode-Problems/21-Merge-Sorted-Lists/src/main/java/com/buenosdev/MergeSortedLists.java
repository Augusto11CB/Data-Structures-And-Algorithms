package com.buenosdev;

public class MergeSortedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode runningPointer = new ListNode();
        ListNode fakeHead = runningPointer;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                runningPointer.next = new ListNode(list1.val);
                runningPointer = runningPointer.next;
                list1 = list1.next;

            } else {
                runningPointer.next = new ListNode(list2.val);
                runningPointer = runningPointer.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            runningPointer.next = list1;
        }
        if (list2 != null) {
            runningPointer.next = list2;
        }

        // fakeHead.next points to the actual head
        return fakeHead.next;
    }

    public static ListNode mergeTwoListsV1(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode headL1 = list1;
        ListNode headL2 = list2;
        ListNode head = null;
        ListNode tail = null;

        while (headL1 != null && headL2 != null) {
            if (headL1.val <= headL2.val) {
                if (head == null) {
                    head = new ListNode(headL1.val);
                    tail = head;
                } else {
                    tail.next = new ListNode(headL1.val);
                    tail = tail.next;
                }
                headL1 = headL1.next;
            } else {
                if (head == null) {
                    head = new ListNode(headL2.val);
                    tail = head;
                } else {
                    tail.next = new ListNode(headL2.val);
                    tail = tail.next;
                }
                headL2 = headL2.next;
            }
        }
        while (headL1 != null) {
            if (head == null) {
                head = new ListNode(headL1.val);
                tail = head;
            } else {
                tail.next = new ListNode(headL1.val);
                tail = tail.next;
            }
            headL1 = headL1.next;
        }

        while (headL2 != null) {
            if (head == null) {
                head = new ListNode(headL2.val);
                tail = head;
            } else {
                tail.next = new ListNode(headL2.val);
                tail = tail.next;
            }
            headL2 = headL2.next;
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
