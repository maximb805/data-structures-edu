package edu.datastructures.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoDirectedListApp<T> {
    private Link<T> first;
    private Link<T> last;

    public TwoDirectedListApp() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T data) {
        Link<T> newLink = new Link<T>(data);
        if (isEmpty())
            last = newLink;
        else
            first.setPrev(newLink);
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(T data) {
        Link<T> newLink = new Link<>(data);
        if (isEmpty())
            first = newLink;
        else {
            newLink.setPrev(last);
            last.setNext(newLink);
        }
        last = newLink;
    }

    public void insertAfter(T key, T data) {
        Link<T> newLink = new Link<>(data);
        if (!isEmpty()) {
            Link<T> current;
            current = first;
            while (current.getNext() != null && !current.getData().equals(key)) {
                current = current.getNext();
            }
            if (current.getData().equals(key)) {
                if (current.getNext() != null) {
                    current.getNext().setPrev(newLink);
                    newLink.setNext(current.getNext());
                } else
                    last = newLink;
                current.setNext(newLink);
                newLink.setPrev(current);
            } else {
                System.out.println(data + "not found");
            }
        } else {
            System.out.println("List's empty");
        }
    }

    public Link<T> deleteFirst() {
        if (!isEmpty()) {
            Link<T> temp = first;
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

    public Link<T> deleteLast() {
        if (!isEmpty()) {
            Link<T> temp = last;
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

    public Link<T> removeElement(T data) {
        if (!isEmpty()) {
            Link<T> current = first;
            while (current != null && !current.getData().equals(data)) {
                current = current.getNext();
            }
            if (current == null) {
                System.out.println(data + " not found");
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
        Link<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("List (last --> first): ");
        Link<T> current = last;
        while (current != null) {
            current.displayLink();
            current = current.getPrev();
        }
        System.out.println();
    }

    public Link<T> findElement(T data) {
        if (!isEmpty()) {
            Link<T> current = first;
            while (current != null && current.getData().equals(data)) {
                current = current.getNext();
            }
            if (current == null) {
                System.out.println(data + " not found");
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

    public Link<T> getFirst() {
        return first;
    }

    public Link<T> getLast() {
        return last;
    }

    public void setFirst(Link<T> first) {
        this.first = first;
    }

    public void setLast(Link<T> last) {
        this.last = last;
    }
}

class TwoDirectedListAppUser {
    public static void main(String[] args) throws IOException {
        TwoDirectedListApp<Integer> list = new TwoDirectedListApp<>();
        ListIterator iterator = list.getIterator();
        list.insertFirst(5);
        boolean breaker = true;

        while (breaker) {
            System.out.println();
            System.out.print("Enter first letter of: show, reset, next, previous, get, before, after, delete or just Enter to exit: ");
            System.out.flush();

            String choice = getChar();
            int value;
            switch (choice) {
                case "s":
                    list.displayForward();
                    break;
                case "r":
                    System.out.println("Reset. Current at first.");
                    iterator.reset();
                    break;
                case "n":
                    System.out.print("Setting current on next... ");
                    iterator.nextLink();
                    System.out.println();
                    break;
                case "p":
                    System.out.print("Setting current on previous... ");
                    iterator.prevLink();
                    System.out.println();
                    break;
                case "g":
                    iterator.getCurrent().displayLink();
                    System.out.println();
                    break;
                case "b":
                    System.out.print("Write int value to insert: ");
                    System.out.flush();
                    value = getInt();
                    System.out.print("Inserting... ");
                    iterator.insertBefore(value);
                    System.out.println();
                    break;
                case "a":
                    System.out.print("Write int value to insert: ");
                    System.out.flush();
                    value = getInt();
                    System.out.print("Inserting... ");
                    iterator.insertAfter(value);
                    System.out.println();
                    break;
                case "d":
                    System.out.println("Deleting... ");
                    iterator.deleteCurrent();
                    break;
                case "":
                    breaker = false;
                    System.out.println("Exiting...");
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

    public static String getChar() throws IOException {
        String s = getString();
        return s.equals("") ? "" : Character.toString(s.charAt(0));
    }

    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}

