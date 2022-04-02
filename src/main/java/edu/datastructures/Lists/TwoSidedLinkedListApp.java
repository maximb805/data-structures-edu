package edu.datastructures.Lists;

public class TwoSidedLinkedListApp {
    private Link first;
    private Link last;

    public TwoSidedLinkedListApp() {
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
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(int intD) {
        Link newLink = new Link(intD);
        if (isEmpty())
            first = newLink;
        else
            last.setNext(newLink);
        last = newLink;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public Link deleteFirst() {
        if (!isEmpty()) {
            Link temp = first;
            if (first.getNext() == null)
                last = null;
            first = first.getNext();
            return temp;
        } else {
            System.out.println("List's empty");
            return null;
        }
    }

    public Link getFirst() {
        return first;
    }

    public Link getLast() {
        return last;
    }
}

class TwoSidedLinkedListAppUser {
    public static void main(String[] args) {
        TwoSidedLinkedListApp list = new TwoSidedLinkedListApp();
        list.insertFirst(17);
        list.insertFirst(16);
        list.insertFirst(15);
        list.insertLast(18);
        list.insertLast(19);
        list.insertLast(20);
        list.displayList();

        list.deleteFirst();
        list.deleteFirst();
        list.displayList();
    }
}