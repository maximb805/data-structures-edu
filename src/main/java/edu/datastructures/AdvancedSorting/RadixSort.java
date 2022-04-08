package edu.datastructures.AdvancedSorting;

import edu.datastructures.ListBasedStackAndQueues.LinkQueue;

public class RadixSort {
    private int[] array;
    private LinkQueue<Integer> list0;
    private LinkQueue<Integer> list1;
    private LinkQueue<Integer> list2;
    private LinkQueue<Integer> list3;
    private LinkQueue<Integer> list4;
    private LinkQueue<Integer> list5;
    private LinkQueue<Integer> list6;
    private LinkQueue<Integer> list7;
    private LinkQueue<Integer> list8;
    private LinkQueue<Integer> list9;

    RadixSort(int size) {
        array = new int[size];
        list0 = new LinkQueue<>();
        list1 = new LinkQueue<>();
        list2 = new LinkQueue<>();
        list3 = new LinkQueue<>();
        list4 = new LinkQueue<>();
        list5 = new LinkQueue<>();
        list6 = new LinkQueue<>();
        list7 = new LinkQueue<>();
        list8 = new LinkQueue<>();
        list9 = new LinkQueue<>();
    }
    //todo methods for different numeral systems
    private int toLists(int a) {
        int list0count = 0;
        for(int i = 0; i < array.length; i++) {
            if ((array[i] % a) / (a / 10) == 0) {
                list0.insert(array[i]);
                list0count++;
                continue;
            }
            if ((array[i] % a) / (a / 10) == 1) {
                list1.insert(array[i]);
                continue;
            }
            if ((array[i] % a) / (a / 10) == 2) {
                list2.insert(array[i]);
                continue;
            }
            if ((array[i] % a) / (a / 10) == 3) {
                list3.insert(array[i]);
                continue;
            }
            if ((array[i] % a) / (a / 10) == 4) {
                list4.insert(array[i]);
                continue;
            }
            if ((array[i] % a) / (a / 10) == 5) {
                list5.insert(array[i]);
                continue;
            }
            if ((array[i] % a) / (a / 10) == 6) {
                list6.insert(array[i]);
                continue;
            }
            if ((array[i] % a) / (a / 10) == 7) {
                list7.insert(array[i]);
                continue;
            }
            if ((array[i] % a) / (a / 10) == 8) {
                list8.insert(array[i]);
                continue;
            }
            if ((array[i] % a) / (a / 10) == 9) {
                list9.insert(array[i]);
            }
        }
        return list0count;
    }

    private void toArray() {
        int i = 0;
        while (!list0.isEmpty()) {
            array[i] = list0.remove().getData();
            i++;
        }
        while (!list1.isEmpty()) {
            array[i] = list1.remove().getData();
            i++;
        }
        while (!list2.isEmpty()) {
            array[i] = list2.remove().getData();
            i++;
        }
        while (!list3.isEmpty()) {
            array[i] = list3.remove().getData();
            i++;
        }
        while (!list4.isEmpty()) {
            array[i] = list4.remove().getData();
            i++;
        }
        while (!list5.isEmpty()) {
            array[i] = list5.remove().getData();
            i++;
        }
        while (!list6.isEmpty()) {
            array[i] = list6.remove().getData();
            i++;
        }
        while (!list7.isEmpty()) {
            array[i] = list7.remove().getData();
            i++;
        }
        while (!list8.isEmpty()) {
            array[i] = list8.remove().getData();
            i++;
        }
        while (!list9.isEmpty()) {
            array[i] = list9.remove().getData();
            i++;
        }
    }

    public void radixSort() {
        int a = 10;
        boolean finish = false;
        while (!finish) {
            int c = toLists(a);
            if(c == array.length)
                finish = true;
            toArray();
            a *= 10;
        }
    }

    public void fillWithRandoms() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }
}

class RadixSortUser {
    public static void main(String[] args) {
        RadixSort array = new RadixSort(1000);
        array.fillWithRandoms();
        array.display();
        System.out.println();
        array.radixSort();
        array.display();
    }
}