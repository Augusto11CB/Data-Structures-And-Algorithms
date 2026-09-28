package com.buenosdev.linkedlist.mergetwosortedlist;
/*
* https://leetcode.com/problems/merge-two-sorted-lists/
* */

// Merge Two Sorted Lists — review date: 2026-09-28
public class Review2026_09_28 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        var l1 = list1;
        var l2 = list2;

        ListNode resultList = new ListNode();
        ListNode resp = resultList;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                resultList.next = new ListNode(l1.val);
                resultList = resultList.next;

                l1 = l1.next;

            } else {
                resultList.next = new ListNode(l2.val);
                resultList = resultList.next;

                l2 = l2.next;
            }
        }

        while (l1 != null) {
            resultList.next = new ListNode(l1.val);
            resultList = resultList.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            resultList.next = new ListNode(l2.val);
            resultList = resultList.next;

            l2 = l2.next;
        }

        return resp.next;
    }
}
