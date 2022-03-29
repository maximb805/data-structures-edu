package edu.datastructures.StackAndQueues;

public class ArrayPriorityQueue
{
    private int maxSize;
    private long[] queue;
    private int front;

    public ArrayPriorityQueue(int size) {
        maxSize = size;
        queue = new long[maxSize];
        front = -1;
    }

    public void insert(long num) throws StackException {
        if(front == maxSize - 1)
            throw new StackException("Queue's full");

        int j = front + 1;
        while (j > 0 && queue[j - 1] < num) {
            queue[j] = queue[j - 1];
            j--;
        }
        queue[j] = num;
        front++;
    }

    public long remove() throws StackException {
        if (front == -1)
            throw new StackException("Queue's empty");

        return queue[front--];
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
}

class ArrayPriorityQueueUser
{
    public static void main(String[] args) {
        ArrayPriorityQueue priorityQueue = new ArrayPriorityQueue(30);

        try {
            while (!priorityQueue.isFull()) {
                long a = (long)(Math.random()*100);
                System.out.print(a + " ");
                priorityQueue.insert(a);
            }
            System.out.println();
            while (!priorityQueue.isEmpty()) {
                System.out.print(priorityQueue.remove() + " ");
            }

        }catch (StackException ex) {
            System.out.println(ex.getMessage());
        }
    }
}