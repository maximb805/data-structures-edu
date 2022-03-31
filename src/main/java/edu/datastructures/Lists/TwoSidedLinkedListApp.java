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

    public void insertFirst(int intD, double doubleD) {
        Link newLink = new Link(intD, doubleD);
        if (isEmpty())
            last = newLink;
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(int intD, double doubleD) {
        Link newLink = new Link(intD, doubleD);
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
}

class TwoSidedLinkedListAppUser {
    public static void main(String[] args) {
        TwoSidedLinkedListApp list = new TwoSidedLinkedListApp();
        list.insertFirst(17, 17.0);
        list.insertFirst(16, 16.0);
        list.insertFirst(15, 15.0);
        list.insertLast(18, 18.0);
        list.insertLast(19, 19.0);
        list.insertLast(20, 20.0);
        list.displayList();

        list.deleteFirst();
        list.deleteFirst();
        list.displayList();

//        Link lastLink = list.deleteLast();
//        lastLink.displayLink();
//        System.out.println();
//
//        list.displayList();
//
//        list.deleteByIntData(16);
//
//        list.displayList();
//
//        Link link = list.findByIntData(10);
//        System.out.println(link);
//        list.findByIntData(17).displayLink();
    }
}