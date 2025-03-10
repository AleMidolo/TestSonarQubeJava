import java.util.Objects;

public class DoublyLinkedList<E> {

    private static class ListNodeImpl<E> {
        E element;
        ListNodeImpl<E> prev;
        ListNodeImpl<E> next;

        ListNodeImpl(E element, ListNodeImpl<E> prev, ListNodeImpl<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private ListNodeImpl<E> head;
    private ListNodeImpl<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addListNode(ListNodeImpl<E> node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void removeListNode(ListNodeImpl<E> node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        node.prev = null;
        node.next = null;
        size--;
    }

    private void moveAllListNodes(DoublyLinkedList<E> list) {
        Objects.requireNonNull(list, "The list to move nodes from cannot be null");

        if (list.head == null) {
            return; // No nodes to move
        }

        // Move all nodes from the source list to this list
        if (this.head == null) {
            this.head = list.head;
            this.tail = list.tail;
        } else {
            this.tail.next = list.head;
            list.head.prev = this.tail;
            this.tail = list.tail;
        }

        // Update the size of this list
        this.size += list.size;

        // Clear the source list
        list.head = null;
        list.tail = null;
        list.size = 0;
    }
}