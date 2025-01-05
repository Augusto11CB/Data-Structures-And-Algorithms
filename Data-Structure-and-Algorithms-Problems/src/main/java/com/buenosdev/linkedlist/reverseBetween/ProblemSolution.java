package com.buenosdev.linkedlist.reverseBetween;


class ProblemSolution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseBetweenFAIL(ListNode head, int left, int right) {
        if (head == null) return null;
        if(Math.abs(left - right)==0) return head;
        ListNode auxHead = head;
        ListNode auxPrev = null;

        ListNode leftN = null;
        ListNode prevLeft = null;

        int countLeft = 1;
        while (auxHead != null) {
            if (countLeft == left) {
                prevLeft = auxPrev;
                leftN = auxHead;
               return invert(auxHead.next, prevLeft, leftN, right, countLeft + 1, head);
            }
            countLeft++;
            auxPrev = auxHead;
            auxHead = auxHead.next;
        }
        return head;
    }

    private ListNode invert(ListNode next, ListNode prevLeft, ListNode leftN, int right, int currentPos, ListNode head) {
        ListNode currentNode = next;
        ListNode auxLeftBehind = leftN;

        int countRight = currentPos;
        while (currentNode != null) {

            if (countRight == right) {
                ListNode temp = currentNode.next;
                currentNode.next = auxLeftBehind;
                auxLeftBehind = currentNode;
                currentNode = temp;
                break;
            }
            countRight++;

        }

        if (currentNode != null) {
            prevLeft.next = currentNode;
            leftN.next = currentNode.next;
            currentNode.next = auxLeftBehind;
        } else {
            leftN.next = null;
            head = auxLeftBehind;
        }

        return head;
    }

    public static void main(String[] args) {
        var sol = new ProblemSolution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

//        ListNode result = sol.reverseBetween(head, 2, 4);
        ListNode result = sol.reverseBetweenFAIL(head, 1, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
