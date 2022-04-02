package edu.datastructures.ListBasedStackAndQueues;

import edu.datastructures.Lists.CyclicListApp;
import edu.datastructures.Lists.Link;

public class CyclicListQueue
{
    private CyclicListApp list;

    CyclicListQueue() {
        list = new CyclicListApp();
    }

    public void insert(int intD) {
        list.insert(intD);
        list.step();
    }

    public Link remove() {
        return list.deleteNext();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayQueue() {
        System.out.print("Queue (first --> last): ");
        list.displayList();
    }
}

class CyclicListQueueUser {
    public static void main(String[] args) {

        CyclicListQueue queue = new CyclicListQueue();
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