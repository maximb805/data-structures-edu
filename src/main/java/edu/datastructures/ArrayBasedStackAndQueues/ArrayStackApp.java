package edu.datastructures.ArrayBasedStackAndQueues;

public class ArrayStackApp {
    private int maxSize;
    private long[] stack;
    private int top;

    public ArrayStackApp(int size) {
        maxSize = size;
        stack = new long[maxSize];
        top = -1;
    }

    public void push(long num) throws StackException {
        if (top == maxSize - 1)
            throw new StackException("Stack's full");

        stack[++top] = num;
    }

    public long pop() throws StackException {
        if (top < 0)
            throw new StackException("Stack's empty");

        return stack[top--];
    }

    public long peek() throws StackException {
        if (top < 0)
            throw new StackException("Stack's empty");

        return stack[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class ArrayStackAppUser {
    public static void main(String[] args) {
        ArrayStackApp stack1 = new ArrayStackApp(30);

        try {
            stack1.push(12);
            stack1.push(11);
            stack1.push(78);
            stack1.push(15);
            System.out.println(stack1.peek());
            System.out.println(stack1.pop());
            System.out.println(stack1.pop());

            while (!stack1.isFull()) {
                long a = (long) (Math.random() * 100);
                System.out.print(a + " ");
                stack1.push(a);
            }
            System.out.println();
            while (!stack1.isEmpty()) {
                System.out.print(stack1.pop() + " ");
            }
        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }
    }
}