package com.buenosdev;

import java.util.ArrayList;

public class RotateList {

    public static void main(String[] args) {
        System.out.println(3 - (4 % 3));
        System.out.println((3 % 2));

    }

    public static ListNode rotateRightV2(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        var myArray = new ArrayList<ListNode>();
        var auxHead = head;
        while (auxHead != null) {
            myArray.add(auxHead);
            auxHead = auxHead.next;
        }
        var listSize = myArray.size();

        myArray.get(listSize - 1).next = head;


        var newTainIndex = listSize - k % listSize; // 0
        head = myArray.get(newTainIndex).next;
        myArray.get(newTainIndex).next = null;

        return head;

        //        myArray.get(listSize - 1).next = head;
        //        var newTainIndex = listSize - (k % listSize);
        //        head = myArray.get(newTainIndex - 1).next;
        //        myArray.get(newTainIndex - 1).next = null;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode aux = head;
        int size = 1;
        while (aux.next != null) {
            size++;
            aux = aux.next;
        }

        aux.next = head;

        for (int i = 0; i < size - k % size; i++) {
            aux = aux.next;
        }

        head = aux.next;
        aux.next = null;

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
