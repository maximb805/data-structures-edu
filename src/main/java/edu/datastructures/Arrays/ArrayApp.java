package edu.datastructures.Arrays;

public class ArrayApp {
    private long[] array;
    private int numAmount = 0;

    ArrayApp(int size) {
        array = new long[size];
    }

    public void fillWithRandoms(int numAmount) {
        for (int i = 0; i < numAmount; i++) {
            add((long) (Math.random() * 100));
        }
    }

    public void add(long num) {
        if (numAmount == array.length) {
            System.out.println("Array's full");
        } else {
            array[numAmount] = num;
            numAmount++;
        }
    }

    public long getElem(int index) {
        return array[index];
    }

    public void delete(long num) {

        for (int i = 0; i < numAmount; ) {
            if (array[i] == num) {
                for (int j = i; j < numAmount - 1; j++) {
                    array[j] = array[j + 1];
                }
                numAmount--;
            }
            if (array[i] == num) ;
            else i++;
        }
    }

    public void search(long num) {
        int matches = 0;
        for (int i = 0; i < numAmount; i++) {
            if (array[i] == num) {
                System.out.println("Found " + num + " at [" + i + "]");
                matches++;
            }
        }
        if (matches == 0)
            System.out.println(num + " not found");
    }

    public void show() {
        System.out.print("[");
        for (int i = 0; i < numAmount; i++) {
            if (i == numAmount - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }
}

class ArrayAppUser {
    public static void main(String[] args) {

        ArrayApp arrayApp = new ArrayApp(50);
        arrayApp.fillWithRandoms(30);
        arrayApp.show();
        arrayApp.search(12);
        arrayApp.add(31);
        arrayApp.show();
        arrayApp.delete(12);
        arrayApp.show();
    }
}
