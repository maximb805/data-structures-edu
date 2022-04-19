package edu.datastructures.Trees.BinTrees;


public class Node<T extends Comparable<T>, R> implements Comparable<T> {
    private T key;
    private R data;
    private Node<T, R> left;
    private Node<T, R> right;

    public Node(T key, R data) {
        this.key = key;
        this.data = data;
    }

    public void displayNode() {
        System.out.print("Key: " + key + " Data: " + data + "\n");
    }

    public R getData() {
        return data;
    }

    public T getKey() {
        return key;
    }

    public Node<T, R> getLeft() {
        return left;
    }

    public void setLeft(Node<T, R> left) {
        this.left = left;
    }

    public Node<T, R> getRight() {
        return right;
    }

    public void setRight(Node<T, R> right) {
        this.right = right;
    }

    @Override
    public int compareTo(T key) {
        return compare(this.key, key);
    }

    private int compare(T thisKey, T anotherKey) {
        if (thisKey instanceof Number && anotherKey instanceof Number) {
            if (((Number) thisKey).doubleValue() == ((Number) anotherKey).doubleValue())
                return 0;
            else
                return ((Number) thisKey).doubleValue() < ((Number) anotherKey).doubleValue() ? -1 : 1;
        } else {
            return thisKey.compareTo(anotherKey);
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", data=" + data +
                '}';
    }
}

