package com.buenosdev;

public class LinkedList<T> {

    /*
     * head and tail are global pointers to the first and last element, respectively, of a singly linked list of integers.
     * */
    private Element<T> head;
    private Element<T> tail;

    public LinkedList() {
    }

    public LinkedList(T val) {
        head = new Element<>(val);
        tail = head;
    }

    public Element<T> removeHead() {
        if (head == null) return null;
        var auxHead = head;
        head = head.next();
        return auxHead;
    }

    /*
     * Implement functions for the following prototypes:
     *
     * bool delete( Element *elem );
     * bool insertAfter( Element *elem, int data );
     *
     * The argument to delete is the element to be deleted.
     * The two arguments to insertAfter give the element after which the new element is to be inserted and the data for the new element.
     * It should be possible to insert at the beginning of the list by calling insertAfter with NULL as the element argument.
     * These functions should return a boolean indicating success.
     * */

    public void delete(Element<T> element) {
        if (head == null) return;

        var auxHead = head;

        while (auxHead.next() != null) {
            if (auxHead.next() == element) {
                if (auxHead.next() == tail) {
                    tail = auxHead;
                }
                auxHead.next = auxHead.next().next();
            } else {
                auxHead = auxHead.next();
            }
        }

    }

    public void insertAfter(Element<T> element, T val) {
        if (element == null) {
            head = new Element<>(val, head);
        }
        var auxHead = head;
        while (auxHead != null) {
            if (auxHead == element) {
                auxHead.next = new Element<>(val, auxHead.next());
                if (auxHead == tail) {
                    tail = auxHead.next();
                }
                return;
            }
            auxHead = auxHead.next();
        }
    }

    class Element<T> {
        private T val;
        private Element<T> next;

        Element() {
        }

        Element(T val) {
            this.val = val;
        }

        Element(T val, Element<T> next) {
            this.val = val;
            this.next = next;
        }

        public T val() {
            return val;
        }

        public Element<T> next() {
            return next;
        }

    }
}
