package edu.datastructures.Arrays;


public class ArraySortingApp
{
    private long[] array;
    private int numAmount;

    ArraySortingApp(int size) {
        array = new long[size];
        numAmount = 0;
    }

    public void bubbleSort() {
        for (int i = numAmount-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    long buffer = array[j];
                    array[j] = array[j+1];
                    array[j+1] = buffer;
                }
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < numAmount; i++) {
            int minIndex = i;
            for (int j = i+1; j < numAmount; j++) {
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

    public void fillWithRandoms(int numAmount) {
        for (int i = 0; i < numAmount; i++) {
            add((long) (Math.random() * 1000000));
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
}

class ArraySortingAppUser
{
    public static void main(String[] args) {
        ArraySortingApp array1 = new ArraySortingApp(30);
        ArraySortingApp array2 = new ArraySortingApp(30);
        ArraySortingApp array3 = new ArraySortingApp(30);
        array1.fillWithRandoms(30);
        array2.fillWithRandoms(30);
        array3.fillWithRandoms(30);
        array1.show("Array1");
        array2.show("Array2");
        array3.show("Array3");
        System.out.println();

        array1.bubbleSort();
        array1.show("Array1 sorted");

        array2.selectionSort();
        array2.show("Array2 sorted");

        array3.insertSort();
        array3.show("Array3 sorted");

    }
}
