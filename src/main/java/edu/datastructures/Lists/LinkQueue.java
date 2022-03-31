package edu.datastructures.Lists;

public class LinkQueue {
    private TwoSidedLinkedListApp list;

    LinkQueue() {
        list = new TwoSidedLinkedListApp();
    }

    public void insert(int intD, double doubleD) {
        list.insertLast(intD, doubleD);
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
        queue.insert(15, 15.0);
        queue.insert(16, 16.0);
        queue.insert(17, 17.0);
        queue.insert(18, 18.0);
        queue.insert(19, 19.0);
        queue.insert(20, 20.0);
        queue.displayQueue();

        while (!queue.isEmpty()) {
            Link elem = queue.remove();
            elem.displayLink();
        }
        System.out.println();
        queue.displayQueue();
    }
}
