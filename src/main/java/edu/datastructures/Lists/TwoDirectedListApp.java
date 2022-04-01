package edu.datastructures.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoDirectedListApp {
    private Link first;
    private Link last;

    TwoDirectedListApp() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int intD) {
        Link newLink = new Link(intD);
        if (isEmpty())
            last = newLink;
        else
            first.setPrev(newLink);
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(int intD) {
        Link newLink = new Link(intD);
        if (isEmpty())
            first = newLink;
        else {
            newLink.setPrev(last);
            last.setNext(newLink);
        }
        last = newLink;
    }

    public void insertAfter(int key, int intData) {
        Link newLink = new Link(intData);
        if (!isEmpty()) {
            Link current;
            current = first;
            while (current.getNext() != null && current.getData() != key) {
                current = current.getNext();
            }
            if (current.getData() == key) {
                if (current.getNext() != null) {
                    current.getNext().setPrev(newLink);
                    newLink.setNext(current.getNext());
                } else
                    last = newLink;
                current.setNext(newLink);
                newLink.setPrev(current);
            } else {
                System.out.println(intData + "not found");
            }
        } else {
            System.out.println("List's empty");
        }
    }

    public Link deleteFirst() {
        if (!isEmpty()) {
            Link temp = first;
            if (first.getNext() == null)
                last = null;
            else
                first.getNext().setPrev(null);
            first = first.getNext();
            return temp;
        } else {
            System.out.println("List's empty");
            return null;
        }
    }

    public Link deleteLast() {
        if (!isEmpty()) {
            Link temp = last;
            if (last.getPrev() == null)
                first = null;
            else
                last.getPrev().setNext(null);
            last = last.getPrev();
            return temp;
        } else {
            System.out.println("List's empty");
            return null;
        }
    }

    public Link removeElement(int intData) {
        if (!isEmpty()) {
            Link current = first;
            while (current != null && current.getData() != intData) {
                current = current.getNext();
            }
            if (current == null) {
                System.out.println(intData + " not found");
            } else {
                if (current == first)
                    first = current.getNext();
                else
                    current.getPrev().setNext(current.getNext());

                if (current == last)
                    last = current.getPrev();
                else
                    current.getNext().setPrev(current.getPrev());
                return current;
            }
        } else {
            System.out.println("List's empty");
        }
        return null;
    }

    public void displayForward() {
        System.out.print("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("List (last --> first): ");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.getPrev();
        }
        System.out.println();
    }

    public Link findElement(int intData) {
        if (!isEmpty()) {
            Link current = first;
            while (current != null && current.getData() != intData) {
                current = current.getNext();
            }
            if (current == null) {
                System.out.println(intData + " not found");
            } else {
                return current;
            }
        } else {
            System.out.println("List's empty");
        }
        return null;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    public Link getFirst() {
        return first;
    }

    public Link getLast() {
        return last;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public void setLast(Link last) {
        this.last = last;
    }
}

class TwoDirectedListAppUser {
    public static void main(String[] args) throws IOException{
        TwoDirectedListApp list = new TwoDirectedListApp();
        ListIterator iterator = list.getIterator();
        list.insertFirst(5);

        while (true) {
            System.out.println();
            System.out.print("Enter first letter of: show, reset, next, previous, get, before, after, delete : ");
            System.out.flush();

            int choice = getChar();
            int value;
            switch (choice) {
                case 's':
                    list.displayForward();
                    break;
                case 'r':
                    System.out.println("Reset. Current at first.");
                    iterator.reset();
                    break;
                case 'n':
                    System.out.print("Setting current on next... ");
                    iterator.nextLink();
                    System.out.println();
                    break;
                case 'p':
                    System.out.print("Setting current on previous... ");
                    iterator.prevLink();
                    System.out.println();
                    break;
                case 'g':
                    iterator.getCurrent().displayLink();
                    System.out.println();
                    break;
                case 'b':
                    System.out.print("Write int value to insert: ");
                    System.out.flush();
                    value = getInt();
                    System.out.print("Inserting: ");
                    iterator.insertBefore(value);
                    System.out.println();
                    break;
                case 'a':
                    System.out.print("Write int value to insert: ");
                    System.out.flush();
                    value = getInt();
                    System.out.print("Inserting: ");
                    iterator.insertAfter(value);
                    System.out.println();
                    break;
                case 'd':
                    System.out.println("Deleting: ");
                    iterator.deleteCurrent();
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static char getChar() throws IOException {
        return getString().charAt(0);
    }

    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}

