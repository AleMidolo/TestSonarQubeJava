package org.class636767631a6d9265ec018171;



public class LinkedList<E> {

    private ListNodeImpl<E> head;

    private ListNodeImpl<E> tail;

    /**
     * Rimuove il nodo non nullo {@code node} dalla lista.
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            // node is head
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            // node is tail
            tail = node.prev;
        }
        node.next = null;
        node.prev = null;
        return true;
    }
}