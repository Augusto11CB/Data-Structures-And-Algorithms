package com.buenosdev.linkedlist.reverselinkedlist

class ProbleSolutionReviewA {

    /*
     https://leetcode.com/problems/reverse-linked-list/
    * */
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        var auxHead: ListNode? = head
        var auxPrev: ListNode? = null

        while (auxHead != null) {
            val temp = auxHead.next
            auxHead.next = auxPrev
            auxPrev = auxHead
            auxHead = temp
        }
        return auxPrev
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}