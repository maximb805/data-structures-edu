package edu.datastructures.Trees.BinTrees;

public class RBNode<T extends Comparable<T>, R> implements Comparable<T> {
    private T key;
    private R data;
    private boolean red;
    private boolean deleted;
    private RBNode<T, R> left;
    private RBNode<T, R> right;
    private RBNode<T, R> parent;

    public RBNode(T key, R data) {
        this.key = key;
        this.data = data;
        deleted = false;
        red = true;
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

    public RBNode<T, R> getLeft() {
        return left;
    }

    public void setLeft(RBNode<T, R> left) {
        this.left = left;
    }

    public RBNode<T, R> getRight() {
        return right;
    }

    public void setRight(RBNode<T, R> right) {
        this.right = right;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public RBNode<T, R> getParent() {
        return parent;
    }

    public void setParent(RBNode<T, R> parent) {
        this.parent = parent;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

