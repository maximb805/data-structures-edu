package edu.datastructures.ListBasedStackAndQueues;

import edu.datastructures.Lists.CyclicListApp;
import edu.datastructures.Lists.Link;

public class CyclicListQueue<T>
{
    private CyclicListApp<T> list;

    CyclicListQueue() {
        list = new CyclicListApp<>();
    }

    public void insert(T data) {
        list.insert(data);
        list.step();
    }

    public Link<T> remove() {
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

        CyclicListQueue<Integer> queue = new CyclicListQueue<>();
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