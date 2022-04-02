package edu.datastructures.ArrayBasedStackAndQueues;

public class ArrayQueueApp {
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
        if (numAmount == maxSize)
            throw new StackException("Queue's full");

        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = num;
        numAmount++;
    }

    public long remove() throws StackException {
        if (numAmount == 0)
            throw new StackException("Queue's empty");

        long first = queue[front++];
        if (front == maxSize) {
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

    public void display(String num) {
        int startPos = front;
        String result;
        result = "Queue nums " + num + ": [";
        for (int i = 0; i < numAmount; i++) {
            if (startPos + i == maxSize)
                startPos = -i;
            if (i == numAmount - 1) {
                result += queue[startPos + i];
                break;
            }
            result += queue[startPos + i] + ", ";
        }
        result += "]";
        System.out.println(result);
    }

    public long getSum() {
        if (isFull())
            return -1;
        int startPos = front;
        long sum = 0;
        for (int i = 0; i < numAmount; i++) {
            if (startPos + i == maxSize)
                startPos = -i;
            sum += queue[i];
        }
        return sum;
    }
}

class ArrayQueueAppUser {
    public static void main(String[] args) {
        ArrayQueueApp queue = new ArrayQueueApp(30);

        try {
            queue.insert(30);
            queue.insert(30);
            queue.insert(30);
            queue.insert(30);
            queue.insert(30);
            queue.insert(30);
            queue.insert(30);
            queue.insert(30);
            queue.remove();
            queue.remove();
            queue.remove();
            System.out.println();

            int i = 0;
            while (i < 15) {
                long a = (long) (Math.random() * 100);
                System.out.print(a + " ");
                queue.insert(a);
                i++;
            }
            System.out.println();

            queue.display("1");
            System.out.println();

            while (!queue.isEmpty()) {
                System.out.print(queue.remove() + " ");
            }
            System.out.println();

            queue.display("1");

            while (!queue.isEmpty()) {
                System.out.print(queue.remove() + " ");
            }

        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }
    }
}