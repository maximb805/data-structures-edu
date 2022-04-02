package edu.datastructures.ListBasedStackAndQueues;

import edu.datastructures.Lists.Link;
import edu.datastructures.Lists.SortedListApp;

public class LinkPriorityQueue {
    SortedListApp list;

    LinkPriorityQueue() {
        list = new SortedListApp();
    }

    public void insert(int num) {
        list.insert(num);
    }

    public Link remove() {
        if (!isEmpty()) {
            return list.deleteFirst();
        }
        return null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayQueue() {
        System.out.print("Queue (first --> last): ");
        list.displayList();
    }
}

class LinkPriorityQueueUser {
    public static void main(String[] args) {
        LinkPriorityQueue queue = new LinkPriorityQueue();

        queue.insert(50);
        queue.insert(60);
        queue.insert(30);
        queue.insert(10);
        queue.insert(90);
        queue.insert(70);
        queue.displayQueue();

        queue.remove().displayLink();
        System.out.println();
        queue.displayQueue();
    }
}
