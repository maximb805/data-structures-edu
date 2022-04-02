package edu.datastructures.ListBasedStackAndQueues;

import edu.datastructures.Lists.Link;
import edu.datastructures.Lists.TwoSidedLinkedListApp;

public class LinkQueue {
    private TwoSidedLinkedListApp list;

    LinkQueue() {
        list = new TwoSidedLinkedListApp();
    }

    public void insert(int intD) {
        list.insertLast(intD);
    }

    public Link remove() {
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

        LinkQueue queue = new LinkQueue();
        queue.insert(15);
        queue.insert(16);
        queue.insert(17);
        queue.insert(18);
        queue.insert(19);
        queue.insert(20);
        queue.displayQueue();

        while (!queue.isEmpty()) {
            Link elem = queue.remove();
            elem.displayLink();
        }
        System.out.println();
        queue.displayQueue();
    }
}
