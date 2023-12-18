package com.buenosdev.linkedlist.mergetwosortedlist;

class ProblemSolution {

    // (Linked List) Problem 3: Merge Two Sorted Lists

    /*
    Given the head of two sorted linked lists, l1 and l2.
    Return a new sorted list created by merging together the nodes of the first two lists.
    **/

    /*
    Example 1:
    Input:
    [1, 3, 5]
    [2, 4, 6]
    Expected Output:
    [1, 2, 3, 4, 5, 6]
    Justification: Merging the two sorted linked lists, node by node, results in a single sorted linked list containing all elements from both input lists.
     * */


    // Main method for testing
    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();

        // Create the first example ListNode instances
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode list2 = new ListNode(1, new ListNode(4));

        // Call mergeTwoLists method and print the result
        ListNode result = solution.mergeTwoLists(list1, list2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode aux = head;

        while (aux != null && aux.next != null) {
            if (aux.val == aux.next.val) {
                if (aux.next.next != null) {
                    aux.next = aux.next.next;
                } else {
                    aux.next = null;
                }
            } else {
                aux = aux.next;
            }
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        var result = new ListNode();
        var fakeHead = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                fakeHead.next = l1;
                fakeHead = fakeHead.next;
                l1 = l1.next;
            } else {
                fakeHead.next = l2;
                fakeHead = fakeHead.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            fakeHead.next = l1;
        }
        if (l2 != null) {
            fakeHead.next = l2;
        }

        return result;

        /*
        Time Complexity: O(n)

        Space Complexity: O(1)
        */
    }
}

class ListNode {
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