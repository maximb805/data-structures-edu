package edu.datastructures.ListBasedStackAndQueues;

import edu.datastructures.Lists.CyclicListApp;
import edu.datastructures.Lists.Link;

public class CyclicListStack
{
    private CyclicListApp list;

    CyclicListStack() {
        list = new CyclicListApp();
    }

    public void push(int intD) {
        list.insert(intD);
    }

    public Link pop() {
        return list.deleteNext();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top --> bottom): ");
        list.displayList();
    }
}

class CyclicListStackUser {
    public static void main(String[] args) {

        CyclicListStack stack = new CyclicListStack();
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