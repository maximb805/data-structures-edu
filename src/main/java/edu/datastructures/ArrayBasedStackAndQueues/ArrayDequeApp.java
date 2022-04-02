package edu.datastructures.ArrayBasedStackAndQueues;

public class ArrayDequeApp {
    private int maxSize;
    private long[] deque;
    private int rear;
    private int front;
    private int numAmount;

    public ArrayDequeApp(int size) {
        maxSize = size;
        deque = new long[maxSize];
        rear = -1;
        front = 0;
        numAmount = 0;
    }

    public void insertLeft(long num) throws StackException {
        if (numAmount == maxSize)
            throw new StackException("Queue's full");

        if (front == 0) {
            front = maxSize;
        }
        deque[--front] = num;
        numAmount++;
    }

    public void insertRight(long num) throws StackException {
        if (numAmount == maxSize)
            throw new StackException("Queue's full");

        if (rear == maxSize - 1) {
            rear = -1;
        }
        deque[++rear] = num;
        numAmount++;
    }

    public long removeLeft() throws StackException {
        if (numAmount == 0)
            throw new StackException("Queue's empty");

        long first = deque[front++];
        if (front == maxSize) {
            front = 0;
        }
        numAmount--;
        return first;
    }

    public long removeRight() throws StackException {
        if (numAmount == 0)
            throw new StackException("Queue's empty");

        long last = deque[rear--];
        if (rear == -1) {
            rear = maxSize - 1;
        }
        numAmount--;
        return last;
    }

    public long peekLeft() throws StackException {
        if (numAmount == 0)
            throw new StackException("Queue's empty");

        return deque[front];
    }

    public long peekRight() throws StackException {
        if (numAmount == 0)
            throw new StackException("Queue's empty");

        return deque[rear];
    }

    public boolean isFull() {
        return numAmount == maxSize;
    }

    public boolean isEmpty() {
        return numAmount == 0;
    }

    public void show() {
        System.out.print("[");
        for (int i = 0; i < numAmount; i++) {
            if (i == numAmount - 1)
                System.out.print(deque[i]);
            else
                System.out.print(deque[i] + ", ");
        }
        System.out.println("]");
    }
}

class ArrayDequeAppUser {
    public static void main(String[] args) {
        ArrayDequeApp deque = new ArrayDequeApp(30);

        deque.show();
        try {
            while (!deque.isFull()) {
                long a = (long) (Math.random() * 100);
                long b = (long) (Math.random() * 100);
                System.out.print(a + " ");
                deque.insertLeft(a);
                System.out.println(b + " ");
                deque.insertRight(b);
            }
            System.out.println();
            while (!deque.isEmpty()) {
                System.out.print(deque.removeLeft() + " ");
                System.out.print(deque.removeRight() + " ");
            }

        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
