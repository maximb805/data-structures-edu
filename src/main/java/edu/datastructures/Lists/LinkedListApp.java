package edu.datastructures.Lists;

public class LinkedListApp<T> {
    private Link<T> first;

    public LinkedListApp() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T data) {
        Link<T> newLink = new Link<>(data);
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(T data) {
        Link<T> newLink = new Link<>(data);
        if (!isEmpty()) {
            Link<T> last = first;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newLink);
        } else {
            first = newLink;
        }
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

    public Link<T> deleteLast() {
        if (!isEmpty()) {
            Link<T> current = first;
            Link<T> prev = null;
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

    public Link<T> deleteByData(T data) {
        if (!isEmpty()) {
            Link<T> current = first;
            Link<T> prev = first;
            while (!current.getData().equals(data)) {
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

    public Link<T> findByData(T data) {
        if (!isEmpty()) {
            Link<T> current = first;
            while (!current.getData().equals(data)) {
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

    public void forEach(ForEachIFace<T> obj) {
        Link<T> current = first;
        while (current != null) {
            current.setData(obj.func(current.getData()));
            current = current.getNext();
        }
    }
}

class LinkedListAppUSer {
    public static void main(String[] args) {
        LinkedListApp<Integer> list = new LinkedListApp<>();
        list.insertFirst(15);
        list.insertFirst(16);
        list.insertFirst(17);
        list.insertFirst(18);
        list.insertFirst(19);
        list.insertLast(20);

        list.displayList();

        Link<Integer> lastLink = list.deleteLast();
        lastLink.displayLink();
        System.out.println();

        list.displayList();

        list.deleteByData(16);

        list.displayList();

        Link<Integer> link = list.findByData(10);
        System.out.println(link);
        list.findByData(17).displayLink();
    }
}
