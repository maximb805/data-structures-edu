package edu.datastructures.StackAndQueues;

public class StackOnDeque {
    ArrayDequeApp deque;

    StackOnDeque(int size) {
        deque = new ArrayDequeApp(size);
    }

    public void push(long num) throws StackException {
        deque.insertRight(num);
    }

    public long pop() throws StackException {
        return deque.removeRight();
    }

    public long peek() throws StackException {
        return deque.peekRight();
    }

    public boolean isFull() {
        return deque.isFull();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }
}

class StackOnDequeUser {
    public static void main(String[] args) {
        StackOnDeque stack1 = new StackOnDeque(30);

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
