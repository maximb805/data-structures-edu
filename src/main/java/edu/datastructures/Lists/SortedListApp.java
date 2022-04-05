package edu.datastructures.Lists;

import java.util.Arrays;

public class SortedListApp<T extends Number> {
    private Link<T> first;

    public SortedListApp() {
        first = null;
    }

    public SortedListApp(T[] array) {
        first = null;
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(T data) {
        Link<T> newLink = new Link<>(data);
        Link<T> current = first;
        Link<T> prev = null;
        while (current != null && (int)current.getData() < (int)data) {
            prev = current;
            current = current.getNext();
        }
        if (prev == null)
            first = newLink;
        else
            prev.setNext(newLink);
        newLink.setNext(current);
    }

    public Link<T> deleteFirst() {
        if (!isEmpty()) {
            Link<T> temp = first;
            first = first.getNext();
            return temp;
        } else {
            System.out.println("List's empty");
            return null;
        }
    }

    public Link<T> find(T data) {
        if (!isEmpty()) {
            Link<T> current = first;
            while (current.getNext() != null && (int) current.getData() < (int) data) {
                current = current.getNext();
            }
            if (current.getData() == data) {
                System.out.println(data + " found");
                return current;
            }
            System.out.println(data + " not found");
        } else {
            System.out.println("List's empty");
        }
        return null;
    }

    public Link<T> delete(T data) {
        if (!isEmpty()) {
            Link<T> current = first;
            Link<T> prev = null;
            while (current.getNext() != null && (int)current.getData() < (int)data) {
                prev = current;
                current = current.getNext();
            }
            if (current.getData() == data) {
                System.out.println(data + " deleted");
                if (prev != null) {
                    prev.setNext(current.getNext());
                } else {
                    first = first.getNext();
                }
                return current;
            }
            System.out.println(data + " not found");
        } else {
            System.out.println("List's empty");
        }
        return null;
    }

    public void displayList() {
        Link<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public Link<T> getFirst() {
        return first;
    }
}

class SortedListAppUser {
    public static void main(String[] args) {
        SortedListApp<Integer> list = new SortedListApp<>();
        list.insert(20);
        list.insert(29);
        list.insert(15);
        list.insert(78);
        list.insert(1);
        list.insert(33);

        list.displayList();
        list.find(78);
        list.find(1);
        list.find(19);

        list.delete(29);
        list.delete(2);
        list.delete(1);
        list.displayList();

        list.delete(15);
        list.delete(78);
        list.delete(33);
        list.delete(20);
        list.displayList();

        Integer[] array = new Integer[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));
        System.out.println();

        SortedListApp<Integer> sortingApp = new SortedListApp<>(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = sortingApp.deleteFirst().getData();
        }
        System.out.println(Arrays.toString(array));
    }
}