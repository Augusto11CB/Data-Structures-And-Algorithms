package com.buenosdev.linkedlist.reverseBetween

class Solution {

    /*
    * https://leetcode.com/problems/reverse-linked-list-ii/description/
    * */

    fun reverseBetweenFAIL(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null) return null
        if (Math.abs(left - right) == 0) return head
        var auxHead: ListNode? = head
        var auxPrev: ListNode? = null

        var leftN: ListNode? = null
        var prevLeft: ListNode? = null

        var countLeft = 1
        while (auxHead != null) {
            if (countLeft == left) {
                prevLeft = auxPrev
                leftN = auxHead
                invert(auxHead.next, prevLeft, leftN, right, countLeft + 1)
                break
            }
            countLeft++
            auxPrev = auxHead
            auxHead = auxHead.next

        }
        return head
    }

    private fun invert(
        next: ListNode?,
        prevLeft: ListNode?,
        leftN: ListNode,
        right: Int,
        currentPos: Int
    ) {
        var currentNode: ListNode? = next
        var auxLeftBehind = leftN

        var countRight = currentPos
        while (currentNode != null) {

            if (countRight == right) {
                val temp = currentNode.next
                currentNode.next = auxLeftBehind
                auxLeftBehind = currentNode
                currentNode = temp
                break
            }
            countRight++

        }

        if (currentNode != null) {
            prevLeft?.next = currentNode
            leftN.next = currentNode.next
            currentNode.next = auxLeftBehind
        }

    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

