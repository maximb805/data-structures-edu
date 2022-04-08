package edu.datastructures.Lists;


public class ComparableLink<T extends Comparable<T>> implements Comparable<T>{
    private T data;
    private ComparableLink<T> next;
    private ComparableLink<T> prev;

    ComparableLink(T data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }

    public ComparableLink<T> getNext() {
        return next;
    }

    public void setNext(ComparableLink<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ComparableLink<T> getPrev() {
        return prev;
    }

    public void setPrev(ComparableLink<T> prev) {
        this.prev = prev;
    }

    @Override
    public int compareTo(T data) {
        return compare(this.data, data);
    }

    private int compare(T thisData, T anotherData) {
        if (thisData instanceof Number && anotherData instanceof Number) {
            if(((Number) thisData).doubleValue() == ((Number) anotherData).doubleValue())
                return 0;
            else
                return ((Number) thisData).doubleValue() < ((Number) anotherData).doubleValue() ? -1 : 1;
        }

        if(thisData instanceof Character) {
            return thisData.compareTo(anotherData);
        }

        if (thisData instanceof String) {
            return thisData.compareTo(anotherData);
        }
        return -1;
    }
}
