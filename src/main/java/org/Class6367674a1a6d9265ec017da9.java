package org;

import java.util.NoSuchElementException;

class Class6367674a1a6d9265ec017da9<E> {
    E data;
    Class6367674a1a6d9265ec017da9<E> next;
    Class6367674a1a6d9265ec017da9<E> prev;

    Class6367674a1a6d9265ec017da9(E data) {
        this.data = data;
    }
}

class DoublyLinkedList<E> {
    private Class6367674a1a6d9265ec017da9<E> head;
    private Class6367674a1a6d9265ec017da9<E> tail;

    public void addClass6367674a1a6d9265ec017da9(Class6367674a1a6d9265ec017da9<E> node) {
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

    public void removeClass6367674a1a6d9265ec017da9(Class6367674a1a6d9265ec017da9<E> node) {
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
     * Sposta in modo atomico tutti i {@link Class6367674a1a6d9265ec017da9 Class6367674a1a6d9265ec017da9s} da {@code list} a questa lista come se ogni nodo fosse stato rimosso con {@link #removeClass6367674a1a6d9265ec017da9(Class6367674a1a6d9265ec017da9Impl)} da {@code list} e successivamente aggiunto a questa lista tramite {@link #addClass6367674a1a6d9265ec017da9(Class6367674a1a6d9265ec017da9Impl)}.
     */
    private void moveAllClass6367674a1a6d9265ec017da9s(DoublyLinkedList<E> list) {
        if (list == null || list.head == null) {
            return; // Nothing to move
        }
        
        Class6367674a1a6d9265ec017da9<E> current = list.head;
        while (current != null) {
            Class6367674a1a6d9265ec017da9<E> nextNode = current.next; // Store next node
            list.removeClass6367674a1a6d9265ec017da9(current); // Remove from the source list
            this.addClass6367674a1a6d9265ec017da9(current); // Add to the current list
            current = nextNode; // Move to the next node
        }
    }
}