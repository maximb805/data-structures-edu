package edu.datastructures.StackAndQueues;

public class ArrayPriorityQueueQuickInsert {
    private int maxSize;
    private long[] queue;
    private int front;

    public ArrayPriorityQueueQuickInsert(int size) {
        maxSize = size;
        queue = new long[maxSize];
        front = -1;
    }

    public void insert(long num) throws StackException {
        if (front == maxSize - 1)
            throw new StackException("Queue's full");

        queue[++front] = num;
    }

    public long remove() throws StackException {
        if (front == -1)
            throw new StackException("Queue's empty");

        long min = queue[0];
        int minIndex = 0;
        for (int i = 1; i <= front; i++) {
            if (queue[i] < min) {
                min = queue[i];
                minIndex = i;
            }
        }
        for (int i = minIndex; i < front; i++) {
            queue[i] = queue[i + 1];
        }
        front--;

        return min;
    }

    public long peek() throws StackException {
        if (front == -1)
            throw new StackException("Queue's empty");

        return queue[front];
    }

    public boolean isFull() {
        return front == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i <= front; i++) {
            if (i == front)
                System.out.print(queue[i]);
            else
                System.out.print(queue[i] + ", ");
        }
        System.out.println("]");
    }
}

class ArrayPriorityQueueQuickInsertUser {
    public static void main(String[] args) {
        ArrayPriorityQueueQuickInsert priorityQueue = new ArrayPriorityQueueQuickInsert(30);

        try {
            while (!priorityQueue.isFull()) {
                long a = (long) (Math.random() * 100);
                System.out.print(a + " ");
                priorityQueue.insert(a);
            }
            System.out.println();
            priorityQueue.display();

            while (!priorityQueue.isEmpty()) {
                System.out.print(priorityQueue.remove() + " ");
            }
            System.out.println();
            priorityQueue.display();
        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }
    }
}