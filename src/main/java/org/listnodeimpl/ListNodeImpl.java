package org.listnodeimpl;

public class ListNodeImpl<E> {

    E value;

    ListNodeImpl<E> next;

    ListNodeImpl<E> prev;

    public ListNodeImpl(E value) {
        this.value = value;
    }
}