import java.util.Objects;

public class DoublyLinkedList<E> {

    private static class ListNodeImpl<E> {
        E element;
        ListNodeImpl<E> next;
        ListNodeImpl<E> prev;

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

    private void removeListNode(ListNodeImpl<E> node) {
        if (node == null) return;

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

    private void addListNode(ListNodeImpl<E> node) {
        if (node == null) return;

        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    /**
     * Mueve atómicamente todos los {@link ListNode ListNodes} de {@code list} a esta lista como si cada nodo se hubiera eliminado con {@link #removeListNode(ListNodeImpl)} de {@code list} y posteriormente agregado a esta lista mediante {@link #addListNode(ListNodeImpl)}.
     */
    private void moveAllListNodes(DoublyLinkedList<E> list) {
        Objects.requireNonNull(list, "La lista no puede ser nula");

        if (list.head == null) return;

        ListNodeImpl<E> current = list.head;
        while (current != null) {
            ListNodeImpl<E> next = current.next;
            list.removeListNode(current);
            this.addListNode(current);
            current = next;
        }
    }
}