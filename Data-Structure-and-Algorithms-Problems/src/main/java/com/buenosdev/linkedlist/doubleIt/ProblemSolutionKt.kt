package com.buenosdev.linkedlist.doubleIt

class ProblemSolutionKt {

    /*
    * https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/
    * */

    class ListNode(var `val`: Int, var next: ListNode? = null)

    fun doubleIt(head: ListNode?): ListNode? {
        var head = head
        if (head == null) return null

        if (head.`val` >= 5) {
            head = ListNode(0, head)
        }

        var node = head
        while (node != null) {
            node.`val` = (node.`val` * 2) % 10
            if (node.next != null && node.next!!.`val` >= 5) {
                node.`val` += 1
            }
            node = node.next
        }
        return head
    }
}