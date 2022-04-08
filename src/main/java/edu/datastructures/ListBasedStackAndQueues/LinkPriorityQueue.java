package edu.datastructures.ListBasedStackAndQueues;

import edu.datastructures.Lists.ComparableLink;
import edu.datastructures.Lists.SortedListApp;

public class LinkPriorityQueue<T extends Comparable<T>> {
    SortedListApp<T> list;

    LinkPriorityQueue() {
        list = new SortedListApp<>();
    }

    public void insert(T data) {
        list.insert(data);
    }

    public ComparableLink<T> remove() {
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
        LinkPriorityQueue<Integer> queue = new LinkPriorityQueue<>();

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
