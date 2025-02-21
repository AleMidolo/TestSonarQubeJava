package org.class636767531a6d9265ec017efb;



public class Bucket {

    // Assuming Bucket has some properties
    private String data;

    private Bucket next;

    public Bucket(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public Bucket getNext() {
        return next;
    }

    public void setNext(Bucket next) {
        this.next = next;
    }
}