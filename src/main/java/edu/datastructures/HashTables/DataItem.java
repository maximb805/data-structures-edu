package edu.datastructures.HashTables;

public class DataItem<T> {
    private int key;
    private T data;

    public DataItem(int key, T data) {
        this.data = data;
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "key=" + key +
                ", data=" + data +
                '}';
    }
}
