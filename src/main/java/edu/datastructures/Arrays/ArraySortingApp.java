package edu.datastructures.Arrays;


import java.util.Arrays;

public class ArraySortingApp {
    private long[] array;
    private int numAmount;

    ArraySortingApp(int size) {
        array = new long[size];
        numAmount = 0;
    }

    public void bubbleSort() {
        for (int i = numAmount - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    long buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                }
            }
        }
    }

    public void bubbleSortBiDirected() {
        int j, leftBoard, rightBoard = numAmount - 1;
        for (leftBoard = 0; leftBoard < rightBoard; ) {
            for (j = leftBoard; j < rightBoard; j++) {
                if (array[j] > array[j + 1]) {
                    long buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                }
            }
            rightBoard--;
            for (j = rightBoard; j > leftBoard; j--) {
                if (array[j] < array[j - 1]) {
                    long buffer = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = buffer;
                }
            }
            leftBoard++;
        }
    }

    public void selectionSort() {
        for (int i = 0; i < numAmount; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numAmount; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            long buffer = array[i];
            array[i] = array[minIndex];
            array[minIndex] = buffer;
        }
    }

    public void insertSort() {
        for (int i = 1; i < numAmount; i++) {
            long buffer = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= buffer) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = buffer;
        }
    }

    public void primNotPrimSort() {
        boolean sorted = false;
        while (!sorted) {
            int prim = 0;
            while (prim < 2) {
                for (int j = (prim % 2) == 0 ? 0 : 1; j < numAmount - 1; j += 2) {
                    if (array[j] > array[j + 1]) {
                        long buffer = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = buffer;
                    }
                }
                prim++;
            }
            int i;
            for (i = 0; i < numAmount - 1; i++) {
                if (array[i] > array[i + 1]) {
                    break;
                }
            }
            if (i == numAmount - 1) {
                sorted = true;
            }
        }
    }

    public void noDubs() {
        for (int i = numAmount - 1; i > 0; i--) {
            if (array[i] == array[i - 1]) {
                array[i] = -1;
            }
        }
        int deleteCounter = 0;
        for (int i = 0; i < numAmount - deleteCounter; i++) {
            while (i + deleteCounter < numAmount && array[i + deleteCounter] == -1) {
                deleteCounter++;
            }
            if (deleteCounter > 0 && i + deleteCounter < numAmount) {
                array[i] = array[i + deleteCounter];
            }
        }
        numAmount -= deleteCounter;
    }

    public void fillWithRandoms(int numAmount) {
        for (int i = 0; i < numAmount; i++) {
            add((long) (Math.random() * 1000));
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

    public void show(String arrayName) {
        System.out.print(arrayName + ": [");
        for (int i = 0; i < numAmount; i++) {
            if (i == numAmount - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }

    public long median() {
        if (array.length % 2 == 1) {
            return array[array.length / 2];
        } else {
            return (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        }
    }
}

class ArraySortingAppUser {
    public static void main(String[] args) {
        ArraySortingApp array1 = new ArraySortingApp(30);
        ArraySortingApp array2 = new ArraySortingApp(30);
        ArraySortingApp array3 = new ArraySortingApp(30);
        ArraySortingApp array4 = new ArraySortingApp(1000);
        array1.fillWithRandoms(30);
        array2.fillWithRandoms(30);
        array3.fillWithRandoms(30);
        array4.fillWithRandoms(1000);
        array1.show("Array1");
        array2.show("Array2");
        array3.show("Array3");
        array4.show("Array4");
        System.out.println();

        array1.bubbleSort();
        array1.show("Array1 sorted");

        array2.insertSort();
        array2.show("Array2 sorted");

        array3.primNotPrimSort();
        array3.show("Array3 sorted");

        array4.bubbleSortBiDirected();
        array4.show("Array4 sorted w/ dubs");
        System.out.println(array4.median());

        array4.noDubs();
        array4.show("Array4 sorted no dubs");

    }
}
