package edu.datastructures.Trees.HuffmanCode;

public class QueueLink<T extends Number, R> {
    private T key;
    private R data;
    private QueueLink<T, R> next;
    private QueueLink<T, R> prev;

    QueueLink(T key, R data) {
        this.key = key;
        this.data = data;
    }

    public void displayLink() {
        System.out.println(key + " " + data + " ");
    }

    public QueueLink<T, R> getNext() {
        return next;
    }

    public void setNext(QueueLink<T, R> next) {
        this.next = next;
    }

    public R getData() {
        return data;
    }

    public T getKey() {
        return key;
    }

    public QueueLink<T, R> getPrev() {
        return prev;
    }

    public void setPrev(QueueLink<T, R> prev) {
        this.prev = prev;
    }

    public int compareTo(QueueLink<T, R> key) {
        return compare(this.key, key.getKey());
    }

    private int compare(T thisKey, T anotherKey) {
        if (thisKey.doubleValue() == anotherKey.doubleValue())
            return 0;
        else
            return thisKey.doubleValue() < anotherKey.doubleValue() ? -1 : 1;
    }
}

