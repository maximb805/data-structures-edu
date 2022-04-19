package edu.datastructures.Lists;

import java.util.LinkedList;
import java.util.List;

public interface ForEachIFace<T> {
    T func(T obj);
}

class Check {
    public static void main(String[] args) {
        LinkedListApp<Integer> list = new LinkedListApp<>();
        list.insertLast(5);
        list.insertLast(6);
        list.insertLast(4);
        list.insertLast(6);
        list.insertLast(7);
        list.insertLast(6);
        list.insertLast(3);
        list.insertLast(2);
        list.displayList();
        list.forEach(c -> {
            Integer f = c;
            if (f >= 6) {
                f += 6;
                System.out.print(f + " ");
            }
            else {
                System.out.print(f + " ");
            }
            return c;
        });
        System.out.println();
        list.displayList();

        List<String> list1 = new LinkedList<>();
        list1.add("4");
        list1.add("7");
        list1.add("6");
        list1.add("7");
        list1.add("6");
        list1.add("7");
        list1.add("6");
        list1.add("7");
        list1.add("6");
        list1.add("7");
        list1.forEach(s -> System.out.print(s + " "));
    }
}