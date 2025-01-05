package com.buenosdev.fastslowpointers.deletemiddle

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/*
* https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
* */


class Solution {

    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) return null

        var fastPointer = head.next?.next
        var slowPointer = head

        while (fastPointer?.next != null) {
            slowPointer = slowPointer?.next
            fastPointer = fastPointer.next?.next
        }

        slowPointer?.next = slowPointer?.next?.next;

        return head
    }

    fun deleteMiddleFAILED(head: ListNode?): ListNode? {
        if (head == null) return null

        var fastPointer = head.next
        var slowPointer = head
        var previous = slowPointer

        while ((slowPointer != null) && fastPointer != null && fastPointer.next != null) {
            previous = slowPointer
            slowPointer = slowPointer.next
            fastPointer = fastPointer.next?.next
        }

        var aux = slowPointer?.next
        previous?.next = aux
        slowPointer?.next = null

        return head
    }
}