package edu.datastructures.Lists;

public class LinkedListApp {
    private Link first;

    public LinkedListApp() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int intData) {
        Link newLink = new Link(intData);
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(int intData) {
        Link newLink = new Link(intData);
        if (!isEmpty()) {
            Link last = first;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newLink);
        } else {
            first = newLink;
        }
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

    public Link deleteLast() {
        if (!isEmpty()) {
            Link current = first;
            Link prev = null;
            while (current.getNext() != null) {
                prev = current;
                current = current.getNext();
            }
            if (prev == null) {
                first = null;
            } else {
                prev.setNext(null);
            }
            return current;
        } else {
            System.out.println("List's empty");
            return null;
        }
    }

    public Link deleteByData(int intData) {
        if (!isEmpty()) {
            Link current = first;
            Link prev = first;
            while (current.getData() != intData) {
                if (current.getNext() == null)
                    return null;
                else {
                    prev = current;
                    current = current.getNext();
                }
            }
            if (current == first)
                first = first.getNext();
            else
                prev.setNext(current.getNext());
            return current;
        } else {
            System.out.println("List's empty");
            return null;
        }
    }

    public Link findByData(int intData) {
        if (!isEmpty()) {
            Link current = first;
            while (current.getData() != intData) {
                if (current.getNext() == null)
                    return null;
                else {
                    current = current.getNext();
                }
            }
            return current;
        } else {
            System.out.println("List's empty");
            return null;
        }
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }
}

class Link {
    private int intData;
    private Link next;
    private Link prev;

    Link(int intData) {
        this.intData = intData;
    }

    public void displayLink() {
        System.out.print("{" + intData + "} ");
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public int getData() {
        return intData;
    }

    public void setData(int intData) {
        this.intData = intData;
    }

    public Link getPrev() {
        return prev;
    }

    public void setPrev(Link prev) {
        this.prev = prev;
    }
}

class LinkedListAppUSer {
    public static void main(String[] args) {
        LinkedListApp list = new LinkedListApp();
        list.insertFirst(15);
        list.insertFirst(16);
        list.insertFirst(17);
        list.insertFirst(18);
        list.insertFirst(19);
        list.insertLast(20);

        list.displayList();

        Link lastLink = list.deleteLast();
        lastLink.displayLink();
        System.out.println();

        list.displayList();

        list.deleteByData(16);

        list.displayList();

        Link link = list.findByData(10);
        System.out.println(link);
        list.findByData(17).displayLink();
    }
}
