package edu.datastructures.StackAndQueues;

public class ArrayQueueApp
{
    private int maxSize;
    private long[] queue;
    private int rear;
    private int front;
    private int numAmount;

    public ArrayQueueApp(int size) {
        maxSize = size;
        queue = new long[maxSize];
        rear = -1;
        front = 0;
        numAmount = 0;
    }

    public void insert(long num) throws StackException {
        if(numAmount == maxSize)
            throw new StackException("Queue's full");

        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = num;
        numAmount ++;
    }

    public long remove() throws StackException {
        if (numAmount == 0)
            throw new StackException("Queue's empty");

        long first = queue[front++];
        if(front == maxSize) {
            front = 0;
        }
        numAmount--;
        return first;
    }

    public long peek() throws StackException {
        if (numAmount == 0)
            throw new StackException("Queue's empty");

        return queue[front];
    }

    public boolean isFull() {
        return numAmount == maxSize;
    }

    public boolean isEmpty() {
        return numAmount == 0;
    }
}

class ArrayQueueAppUser
{
    public static void main(String[] args) {
        ArrayQueueApp queue = new ArrayQueueApp(30);

        try {
//            queue.insert(30);
//            queue.insert(30);
//            queue.insert(30);
//            queue.insert(30);
//            queue.insert(30);
//            queue.insert(30);
//            queue.insert(30);
//            queue.insert(30);
//            queue.remove();
//            queue.remove();
//            queue.remove();
//            System.out.println();

            while (!queue.isFull()) {
                long a = (long) (Math.random() * 100);
                System.out.print(a + " ");
                queue.insert(a);
            }
            System.out.println();
            while (!queue.isEmpty()) {
                System.out.print(queue.remove() + " ");
            }
        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
