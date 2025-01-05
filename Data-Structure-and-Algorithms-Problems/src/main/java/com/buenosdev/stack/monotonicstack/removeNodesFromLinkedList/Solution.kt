package com.buenosdev.stack.monotonicstack.removeNodesFromLinkedList

import java.util.*

class Solution {

    public class ListNode(var `val`: Int) {
        public var next: ListNode? = null
    }

    fun removeNodes(head: ListNode?): ListNode? {
        val stack = Stack<ListNode>()

        var auxHead = head

        while (auxHead != null) {
            while (stack.isNotEmpty() && stack.peek().`val` < auxHead.`val`) {
                stack.pop()
            }
            stack.push(auxHead)
            auxHead = auxHead.next
        }

        var resultListHead = ListNode(stack.pop().`val`)
        var resultListNext = resultListHead
        while (stack.isNotEmpty()) {
            resultListHead = ListNode(stack.pop().`val`)
            resultListHead.next = resultListNext
            resultListNext = resultListHead
        }
        return resultListHead

    }



}