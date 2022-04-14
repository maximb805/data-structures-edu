package edu.datastructures.Trees.HuffmanCode;


public class PriorityQueue<T extends Number, R> {
    private QueueLink<T, R> last;
    private QueueLink<T, R> first;

    public PriorityQueue() {
        last = null;
        first = null;
    }

    public void insert(T key, R data) {
        QueueLink<T, R> newLink = new QueueLink<>(key, data);
        if (isEmpty())
            last = first = newLink;
        else {
            QueueLink<T, R> current = last;
            while (current.compareTo(newLink) >= 0) {
                current = current.getPrev();
                if (current == null) {
                    newLink.setNext(first);
                    first.setPrev(newLink);
                    first = newLink;
                    return;
                }
            }
            if (current != last) {
                current.getNext().setPrev(newLink);
                newLink.setNext(current.getNext());
            } else {
                last = newLink;
            }
            current.setNext(newLink);
            newLink.setPrev(current);
        }
    }

    public QueueLink<T, R> remove() {
        if (!isEmpty()) {
            QueueLink<T, R> deletedLink = first;
            if (last == first) {
                last = first = null;
            } else {
                first = first.getNext();
                first.setPrev(null);
            }
            return deletedLink;
        } else {
            System.out.println("Queue is empty");
            return null;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public QueueLink<T, R> peek() {
        if (!isEmpty())
            return first;
        else {
            System.out.println("Queue is empty");
            return null;
        }
    }

    public void displayQueue() {
        if (!isEmpty()) {
            System.out.println("Queue (first --> last): ");
            QueueLink<T, R> current = first;
            while (current != null) {
                current.displayLink();
                current = current.getNext();
            }
        } else {
            System.out.println("Queue is empty");
        }
    }
}

