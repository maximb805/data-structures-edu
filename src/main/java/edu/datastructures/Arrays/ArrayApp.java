package edu.datastructures.Arrays;

import java.util.Arrays;

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

    public long getMax() {
        if (numAmount == 0) {
            System.out.println("Array's empty");
            return -1;
        } else {
            long max = array[0];
            for (int i = 0; i < numAmount; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
            }
            return max;
        }
    }

    public long removeMax() {
        if (numAmount == 0) {
            System.out.println("Array's empty");
            return -1;
        } else {
            long max = array[0];
            int maxIndex = 0;
            if (numAmount > 1) {
                for (int i = 0; i < numAmount; i++) {
                    if (max < array[i]) {
                        max = array[i];
                        maxIndex = i;
                    }
                }
                deleteByIndex(maxIndex);
            } else {
                delete(array[0]);
            }
            return max;
        }
    }

    public long getElem(int index) {
        return array[index];
    }

    public void noDubs() {
        for (int i = 0; i < numAmount; i++) {
            for (int j = i + 1; j < numAmount; j++) {
                if (array[j] == array[i]) {
                    array[j] = -1;
                }
            }
        }
        delete(-1);
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

    public void deleteByIndex(int index) {
        for (int i = index; i < numAmount - 1; i++) {
            array[i] = array[i + 1];
        }
        numAmount--;
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

    public int getNumAmount() {
        return numAmount;
    }
}

class ArrayAppUser {
    public static void main(String[] args) {

        ArrayApp arrayApp = new ArrayApp(50);

        arrayApp.fillWithRandoms(30);
        arrayApp.show();
        System.out.println();

        arrayApp.search(12);
        arrayApp.add(31);
        arrayApp.show();
        System.out.println();

        arrayApp.delete(12);
        arrayApp.show();
        System.out.println(arrayApp.getMax());

        arrayApp.removeMax();
        arrayApp.show();
        System.out.println();

        //для задания
        int sortedArrayLength = arrayApp.getNumAmount();
        long[] sortedArray = new long[sortedArrayLength];

        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = arrayApp.removeMax();
        }
        for (int i = sortedArrayLength - 1; i >= 0; i--) {
            arrayApp.add(sortedArray[i]);
        }
        arrayApp.show();
        arrayApp.noDubs();
        arrayApp.show();
    }
}
