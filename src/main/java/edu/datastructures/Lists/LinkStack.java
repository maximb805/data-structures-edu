package edu.datastructures.Lists;

public class LinkStack
{
    private LinkedListApp list;

    LinkStack() {
        list = new LinkedListApp();
    }

    public void push(int intD, double doubleD) {
        list.insertFirst(intD, doubleD);
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

class LinkStackUser
{
    public static void main(String[] args) {
        LinkStack stack = new LinkStack();
        stack.push(15, 15.0);
        stack.push(16, 16.0);
        stack.push(17, 17.0);
        stack.push(18,18.0);
        stack.push(19,19.0);
        stack.push(20,20.0);
        stack.displayStack();

        while (!stack.isEmpty()) {
            Link elem = stack.pop();
            elem.displayLink();
        }
        System.out.println();
        stack.displayStack();
    }
}