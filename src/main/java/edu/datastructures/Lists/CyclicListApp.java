package edu.datastructures.Lists;

//one directed
public class CyclicListApp
{
    private Link current;

    public CyclicListApp() {
        current = null;
    }

    public boolean isEmpty() {
        return current == null;
    }

    public void insert(int intData) {
        Link newLink = new Link(intData);
        if(!isEmpty()) {
            newLink.setNext(current.getNext());
            current.setNext(newLink);
        } else {
            current = newLink;
            current.setNext(current);
        }
    }

    public Link deleteNext() {
        if (!isEmpty()) {
            Link temp = current.getNext();
            if(temp == current) {
                current = null;
            } else {
                current.setNext(temp.getNext());
            }
            return temp;
        } else {
            System.out.println("List's empty");
            return null;
        }
    }

    public Link deleteByData(int intData) {
        if (!isEmpty()) {
            if (current.getNext().getData() == intData)
                return deleteNext();
            Link marker = current;
            current = current.getNext();
            while (current != marker) {
                if (current.getNext().getData() == intData)
                    return deleteNext();
                current = current.getNext();
            }
            System.out.println(intData + " not found");
        } else {
            System.out.println("List's empty");
        }
        return null;
    }

    public Link find(int intData) {
        if (!isEmpty()) {
            if (current.getData() == intData)
                return current;
            Link marker = current;
            current = current.getNext();
            while (current != marker) {
                if (current.getData() == intData)
                    return current;
                current = current.getNext();
            }
            System.out.println(intData + " not found");
        } else {
            System.out.println("List's empty");
        }
        return null;
    }

    public void step() {
        if(isEmpty())
            return;
        current = current.getNext();
    }

    public void displayList() {
        if (isEmpty())
            return;
        Link marker = current;
        marker.displayLink();
        current = current.getNext();
        while (current != marker) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public Link getCurrent() {
        return current;
    }
}

class CyclicListAppUser {
    public static void main(String[] args) {
        CyclicListApp list = new CyclicListApp();
        list.displayList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.displayList();
        list.getCurrent().displayLink();
        System.out.println();
        list.deleteNext();
        list.displayList();
        list.find(40);
        list.find(41);
        list.deleteByData(30);
        list.deleteByData(31);
        list.displayList();
        list.deleteByData(20);
        list.deleteByData(40);
        list.deleteByData(50);
        list.displayList();
        System.out.println(list.getCurrent());
    }
}
