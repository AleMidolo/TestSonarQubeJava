import java.util.NoSuchElementException;

public class ListNode<E> {
    private E element;
    private ListNode<E> next;
    private ListNode<E> prev;
    private int currentPosition;
    private ListNode<E> current;

    /**
     * Returns the previous node in the linked list
     * @return The previous node
     * @throws NoSuchElementException if there is no previous node
     */
    @Override
    public ListNode<E> nodoAnterior() {
        if (current == null || current.prev == null) {
            throw new NoSuchElementException("No previous node exists");
        }
        current = current.prev;
        currentPosition--;
        return current;
    }
}