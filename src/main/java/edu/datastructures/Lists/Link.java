package edu.datastructures.Lists;

public class Link<T> {
    private T data;
    private Link<T> next;
    private Link<T> prev;

    Link(T data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Link<T> getPrev() {
        return prev;
    }

    public void setPrev(Link<T> prev) {
        this.prev = prev;
    }
}

