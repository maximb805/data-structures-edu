package edu.datastructures.ListBasedStackAndQueues;

import edu.datastructures.Lists.Link;
import edu.datastructures.Lists.TwoSidedLinkedListApp;

public class LinkQueue<T> {
    private TwoSidedLinkedListApp<T> list;

    public LinkQueue() {
        list = new TwoSidedLinkedListApp<>();
    }

    public void insert(T data) {
        list.insertLast(data);
    }

    public Link<T> remove() {
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayQueue() {
        System.out.print("Queue (first --> last): ");
        list.displayList();
    }
}

class LinkQueueUser {
    public static void main(String[] args) {

        LinkQueue<Integer> queue = new LinkQueue<>();
        queue.insert(15);
        queue.insert(16);
        queue.insert(17);
        queue.insert(18);
        queue.insert(19);
        queue.insert(20);
        queue.displayQueue();

        while (!queue.isEmpty()) {
            Link<Integer> elem = queue.remove();
            elem.displayLink();
        }
        System.out.println();
        queue.displayQueue();
    }
}
