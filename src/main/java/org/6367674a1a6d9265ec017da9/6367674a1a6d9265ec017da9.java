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

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void addListNode(ListNode<E> node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        if (head == null) {
            head = node;
            tail = node;
            node.next = null;
            node.prev = null;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;
        }
    }

    public void removeListNode(ListNode<E> node) {
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
        node.next = null;
        node.prev = null;
    }

    /**
     * Atomically moves all {@link ListNode ListNodes} from {@code list} to this list as if each node was removed with
     * {@link #removeListNode(ListNodeImpl)} from {@code list} and subsequently added to this list by
     * {@link #addListNode(ListNodeImpl)}.
     */
    private void moveAllListNodes(DoublyLinkedList<E> list) {
        if (list == null || list.head == null) {
            return; // Nothing to move
        }

        ListNode<E> current = list.head;
        while (current != null) {
            ListNode<E> nextNode = current.next; // Store next node
            list.removeListNode(current); // Remove from the source list
            this.addListNode(current); // Add to this list
            current = nextNode; // Move to the next node
        }
    }
}