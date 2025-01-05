package com.buenosdev.fastslowpointers.hascicle


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return true

        var fastPointer = head.next
        var slowPointer = head

        while ((slowPointer != null) && fastPointer != null && fastPointer.next != null) {
            if (slowPointer.equals(fastPointer)) return true
            slowPointer = slowPointer.next
            fastPointer = fastPointer.next?.next
        }

        return false
    }
}