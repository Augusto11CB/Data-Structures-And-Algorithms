package com.buenosdev.hashset.detectcycle

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head?.next == null) return null

        var hashSet = HashSet<ListNode>()
        // var fastPointer = head.next?.next
        var slowPointer = head

        while (slowPointer != null) {
            if (hashSet.contains(slowPointer)) return slowPointer
            hashSet.add(slowPointer)
            slowPointer = slowPointer?.next

        }
        return null
    }
}