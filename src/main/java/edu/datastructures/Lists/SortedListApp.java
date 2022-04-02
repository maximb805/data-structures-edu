package edu.datastructures.Lists;

import java.util.Arrays;

public class SortedListApp {
    private Link first;

    public SortedListApp() {
        first = null;
    }

    public SortedListApp(int[] array) {
        first = null;
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(int intData) {
        Link newLink = new Link(intData);
        Link current = first;
        Link prev = null;
        while (current != null && current.getData() < intData) {
            prev = current;
            current = current.getNext();
        }
        if (prev == null)
            first = newLink;
        else
            prev.setNext(newLink);
        newLink.setNext(current);
    }

    public Link deleteFirst() {
        if (!isEmpty()) {
            Link temp = first;
            first = first.getNext();
            return temp;
        } else {
            System.out.println("List's empty");
            return null;
        }
    }

    public Link find(int intD) {
        if (!isEmpty()) {
            Link current = first;
            while (current.getNext() != null && current.getData() < intD) {
                current = current.getNext();
            }
            if (current.getData() == intD) {
                System.out.println(intD + " found");
                return current;
            }
            System.out.println(intD + " not found");
        } else {
            System.out.println("List's empty");
        }
        return null;
    }

    public Link delete(int intD) {
        if (!isEmpty()) {
            Link current = first;
            Link prev = null;
            while (current.getNext() != null && current.getData() < intD) {
                prev = current;
                current = current.getNext();
            }
            if (current.getData() == intD) {
                System.out.println(intD + " deleted");
                if (prev != null) {
                    prev.setNext(current.getNext());
                } else {
                    first = first.getNext();
                }
                return current;
            }
            System.out.println(intD + " not found");
        } else {
            System.out.println("List's empty");
        }
        return null;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public Link getFirst() {
        return first;
    }
}

class SortedListAppUser {
    public static void main(String[] args) {
        SortedListApp list = new SortedListApp();
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

        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));
        System.out.println();

        SortedListApp sortingApp = new SortedListApp(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = sortingApp.deleteFirst().getData();
        }
        System.out.println(Arrays.toString(array));
    }
}