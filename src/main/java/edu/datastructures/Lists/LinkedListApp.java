package edu.datastructures.Lists;

public class LinkedListApp {
    private Link first;

    public LinkedListApp() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int intData, double doubleData) {
        Link newLink = new Link(intData, doubleData);
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(int intData, double doubleData) {
        Link newLink = new Link(intData, doubleData);
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

    public Link deleteByIntData(int intData) {
        if (!isEmpty()) {
            Link current = first;
            Link prev = first;
            while (current.getIntData() != intData) {
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

    public Link findByIntData(int intData) {
        if (!isEmpty()) {
            Link current = first;
            while (current.getIntData() != intData) {
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
    private double doubleData;
    private Link next;

    Link(int intData, double doubleData) {
        this.intData = intData;
        this.doubleData = doubleData;
    }

    public void displayLink() {
        if (!(this == null)) {
            System.out.print("{" + intData + ", " + doubleData + "} ");
        } else {
            System.out.println("there's no such element in the list");
        }
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public int getIntData() {
        return intData;
    }

    public void setIntData(int intData) {
        this.intData = intData;
    }

    public double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(double doubleData) {
        this.doubleData = doubleData;
    }
}

class LinkedListAppUSer {
    public static void main(String[] args) {
        LinkedListApp list = new LinkedListApp();
        list.insertFirst(15, 15.0);
        list.insertFirst(16, 16.0);
        list.insertFirst(17, 17.0);
        list.insertFirst(18, 18.0);
        list.insertFirst(19, 19.0);
        list.insertLast(20, 20.0);

        list.displayList();

        Link lastLink = list.deleteLast();
        lastLink.displayLink();
        System.out.println();

        list.displayList();

        list.deleteByIntData(16);

        list.displayList();

        Link link = list.findByIntData(10);
        System.out.println(link);
        list.findByIntData(17).displayLink();
    }
}
