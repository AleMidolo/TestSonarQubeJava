package org.class6367674a1a6d9265ec017da9;

import java.util.NoSuchElementException;

class ListNode<E> {
    E data;
    ListNode<E> next;
    ListNode<E> prev;

    ListNode(E data) {
        this.data = data;
    }
}

class DoublyLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;

    public void addListNode(ListNode<E> node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void removeListNode(ListNode<E> node) {
        if (node == null || head == null) {
            throw new NoSuchElementException("Node not found or list is empty");
        }
        if (node == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            node.prev.next = node.next;
        }
        if (node == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }
        node.next = node.prev = null; // Clear references
    }

    /**
     * Sposta in modo atomico tutti i {@link ListNode ListNodes} da {@code list} a questa lista come se ogni nodo fosse stato rimosso con {@link #removeListNode(ListNodeImpl)} da {@code list} e successivamente aggiunto a questa lista tramite {@link #addListNode(ListNodeImpl)}.
     */
    private void moveAllListNodes(DoublyLinkedList<E> list) {
        if (list == null || list.head == null) {
            return; // Nothing to move
        }
        
        ListNode<E> current = list.head;
        while (current != null) {
            ListNode<E> nextNode = current.next; // Store next node
            list.removeListNode(current); // Remove from the source list
            this.addListNode(current); // Add to the current list
            current = nextNode; // Move to the next node
        }
    }
}