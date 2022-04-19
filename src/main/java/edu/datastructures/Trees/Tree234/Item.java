package edu.datastructures.Trees.Tree234;

public class Item <T extends Comparable<T>, R> implements Comparable<T>{
    private T key;
    private R data;

    public Item(T key, R data) {
        this.key = key;
        this.data = data;
    }

    public T getKey() {
        return key;
    }

    public R getData() {
        return data;
    }

    @Override
    public int compareTo(T obj) {
        return compare(this.key, obj);
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
        return "Item{" +
                "key=" + key +
                ", data=" + data +
                '}';
    }
}
