package edu.datastructures.ListBasedStackAndQueues;

import edu.datastructures.Lists.Link;
import edu.datastructures.Lists.LinkedListApp;

public class LinkStack {
    private LinkedListApp list;

    LinkStack() {
        list = new LinkedListApp();
    }

    public void push(int intD) {
        list.insertFirst(intD);
    }

    public Link pop() {
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top --> bottom): ");
        list.displayList();
    }
}

class LinkStackUser {
    public static void main(String[] args) {
        LinkStack stack = new LinkStack();
        stack.push(15);
        stack.push(16);
        stack.push(17);
        stack.push(18);
        stack.push(19);
        stack.push(20);
        stack.displayStack();

        while (!stack.isEmpty()) {
            Link elem = stack.pop();
            elem.displayLink();
        }
        System.out.println();
        stack.displayStack();
    }
}