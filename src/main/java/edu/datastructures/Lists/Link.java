package edu.datastructures.Lists;

public class Link {
    private int intData;
    private Link next;
    private Link prev;
    private Link upper;
    private Link lower;

    Link(int intData) {
        this.intData = intData;
    }

    public void displayLink() {
        System.out.print("{" + intData + "} ");
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public int getData() {
        return intData;
    }

    public void setData(int intData) {
        this.intData = intData;
    }

    public Link getPrev() {
        return prev;
    }

    public void setPrev(Link prev) {
        this.prev = prev;
    }
}
