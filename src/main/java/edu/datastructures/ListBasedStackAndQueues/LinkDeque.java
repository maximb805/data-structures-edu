package edu.datastructures.ListBasedStackAndQueues;

import edu.datastructures.Lists.Link;
import edu.datastructures.Lists.TwoDirectedListApp;

public class LinkDeque {
    TwoDirectedListApp list;

    public LinkDeque() {
        list = new TwoDirectedListApp();
    }

    public void insertLeft(int num) {
        list.insertFirst(num);
    }

    public void insertRight(int num) {
        list.insertLast(num);
    }

    public Link removeLeft() {
        if (!isEmpty()) {
            return list.deleteFirst();
        }
        return null;
    }

    public Link removeRight() {
        if (!isEmpty()) {
            return list.deleteLast();
        }
        return null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void show() {
        list.displayForward();
    }
}

class LinkDequeUser {
    public static void main(String[] args) {
        LinkDeque deque = new LinkDeque();
        int i = 0;
        deque.show();
        while (i < 10) {
            int a = (int) (Math.random() * 100);
            int b = (int) (Math.random() * 100);
            System.out.print(a + " ");
            deque.insertLeft(a);
            System.out.println(b + " ");
            deque.insertRight(b);
            i++;
        }
        System.out.println();
        deque.show();
        System.out.println();
        while (!deque.isEmpty()) {
            deque.removeLeft().displayLink();
            deque.removeRight().displayLink();
        }
    }
}