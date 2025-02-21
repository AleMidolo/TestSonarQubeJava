package org.class636767631a6d9265ec018171;



public class ListNodeImpl<E> {

    E value;

    ListNodeImpl<E> next;

    ListNodeImpl<E> prev;

    public ListNodeImpl(E value) {
        this.value = value;
    }
}