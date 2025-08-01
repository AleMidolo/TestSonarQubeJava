import java.util.Objects;

public class DoublyLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    private static class ListNode<E> {
        E item;
        ListNode<E> prev;
        ListNode<E> next;

        ListNode(E element, ListNode<E> prev, ListNode<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 原子性地将所有 {@link ListNode ListNodes} 从 {@code list} 移动到此列表，就像每个节点都是通过 {@link #removeListNode(ListNodeImpl)} 从 {@code list} 中移除的，然后依次通过 {@link #addListNode(ListNodeImpl)} 添加到此列表中。
     */
    private void moveAllListNodes(DoublyLinkedList<E> list) {
        Objects.requireNonNull(list);
        
        if (list == this || list.size == 0) {
            return;
        }

        // If this list is empty
        if (size == 0) {
            head = list.head;
            tail = list.tail;
        } else {
            // Connect the tail of this list to the head of the other list
            tail.next = list.head;
            list.head.prev = tail;
            tail = list.tail;
        }

        // Update size
        size += list.size;

        // Clear the other list
        list.head = null;
        list.tail = null;
        list.size = 0;
    }
}