package edu.datastructures.Lists;

public class ListIterator {
    private Link current;
    private TwoDirectedListApp list;

    ListIterator(TwoDirectedListApp list) {
        this.list = list;
        reset();
    }

    public void reset() {
        current = list.getFirst();
    }

    public void nextLink() {
        if (current == list.getLast())
            System.out.print("\"current\" at last element");
        else
            current = current.getNext();
    }

    public void prevLink() {
        if (current == list.getFirst())
            System.out.print("\"current\" at first element");
        else
            current = current.getPrev();
    }

    public void insertAfter(int intData) {
        if (current == null) {
            System.out.print("\"current\" == null");
        } else {
            Link newLink = new Link(intData);
            if (current.getNext() != null) {
                current.getNext().setPrev(newLink);
                newLink.setNext(current.getNext());
            } else
                list.setLast(newLink);
            current.setNext(newLink);
            newLink.setPrev(current);
            current = newLink;
        }
    }

    public void insertBefore(int intData) {
        if (current == null) {
            System.out.print("\"current\" == null");
        } else {
            Link newLink = new Link(intData);
            if (current.getPrev() != null) {
                current.getPrev().setNext(newLink);
                newLink.setPrev(current.getPrev());
            } else
                list.setFirst(newLink);
            current.setPrev(newLink);
            newLink.setNext(current);
            current = newLink;
        }
    }

    public int deleteCurrent() {
        if (current == null) {
            System.out.print("\"current\" == null");
            return -1;
        } else {
            int val = current.getData();
            if (current.getPrev() == null)
                list.setFirst(current.getNext());
            else
                current.getPrev().setNext(current.getNext());

            if (current.getNext() == null)
                list.setLast(current.getPrev());
            else
                current.getNext().setPrev(current.getPrev());

            if (atEnd())
                reset();
            else
                current = current.getNext();

            return val;
        }
    }

    public Link getCurrent() {
        return current;
    }

    public boolean atEnd() {
        return current.getNext() == null;
    }

    public void setCurrent(Link current) {
        this.current = current;
    }

}
