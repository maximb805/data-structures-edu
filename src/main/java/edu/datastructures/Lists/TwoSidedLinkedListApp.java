package edu.datastructures.Lists;

public class TwoSidedLinkedListApp<T> {
    private Link<T> first;
    private Link<T> last;

    public TwoSidedLinkedListApp() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T data) {
        Link<T> newLink = new Link<>(data);
        if (isEmpty())
            last = newLink;
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(T data) {
        Link<T> newLink = new Link<>(data);
        if (isEmpty())
            first = newLink;
        else
            last.setNext(newLink);
        last = newLink;
    }

    public void displayList() {
        Link<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public Link<T> deleteFirst() {
        if (!isEmpty()) {
            Link<T> temp = first;
            if (first.getNext() == null)
                last = null;
            first = first.getNext();
            return temp;
        } else {
            System.out.println("List's empty");
            return null;
        }
    }

    public Link<T> getFirst() {
        return first;
    }

    public Link<T> getLast() {
        return last;
    }
}

class TwoSidedLinkedListAppUser {
    public static void main(String[] args) {
        TwoSidedLinkedListApp<Integer> list = new TwoSidedLinkedListApp<>();
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