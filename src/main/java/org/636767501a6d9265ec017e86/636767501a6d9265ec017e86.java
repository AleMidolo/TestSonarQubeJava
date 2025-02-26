import java.util.NoSuchElementException;

class ListNode<E> {
    E data;
    ListNode<E> next;

    public ListNode(E data) {
        this.data = data;
        this.next = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListNode<E> nodoPrecedente() {
        if (this.next == null) {
            throw new NoSuchElementException("No previous node exists.");
        }
        return this.next;
    }
}