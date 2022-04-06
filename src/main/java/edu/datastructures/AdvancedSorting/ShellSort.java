package edu.datastructures.AdvancedSorting;

public class ShellSort {
    private int[] array;

    ShellSort(int size) {
        array = new int[size];
    }

    public void shellSort() {
        int h = 1;
        while (h < array.length) {
            h = h * 3 + 1;
        }
        int buffer;
        while (h > 1) {
            h = (h - 1) / 3;
            for (int i = h; i < array.length; i++) {
                buffer = array[i];
                int j = i;
                while (j >= h && array[j - h] > buffer) {
                    array[j] = array[j - h];
                    j -= h;
                }
                array[j] = buffer;
            }
            System.out.println("h = " + h);
            display();
            System.out.println();
        }
    }

    public void fillWithRandoms() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
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

class ShellSortUser {
    public static void main(String[] args) {
        ShellSort array = new ShellSort(35);
        array.fillWithRandoms();
        array.display();
        array.shellSort();
        array.display();
    }
}
