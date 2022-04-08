package edu.datastructures.Arrays.Recursion;

public class MergeSortingApp {
    private int[] array;
    private int[] workSpace;

    MergeSortingApp(int size) {
        array = new int[size];
        workSpace = new int[size];
    }

    public int[] fillWithRandoms() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    public void show() {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }

    public void sortArray() {
        int leftBound = 0;
        int rightBound = array.length - 1;
        split(workSpace, leftBound, rightBound);
    }

    private void split(int[] workSpace, int leftBound, int rightBound) {
        if (leftBound == rightBound) {
            return;
        }
        int mid = (leftBound + rightBound) / 2;
        split(workSpace, leftBound, mid);
        split(workSpace, mid + 1, rightBound);
        merge(workSpace, leftBound, mid + 1, rightBound);
    }

    private void merge(int[] workSpace, int leftBound, int mid, int rightBound) {
        int i = 0;
        int low = leftBound;
        int high = mid;

        while (low < mid && high <= rightBound) {
            if (array[low] < array[high])
                workSpace[i++] = array[low++];
            else
                workSpace[i++] = array[high++];
        }

        while (low < mid) {
            workSpace[i++] = array[low++];
        }
        while (high <= rightBound) {
            workSpace[i++] = array[high++];
        }

        for (i = 0; i < rightBound - leftBound + 1; i++) {
            array[leftBound + i] = workSpace[i];
        }
    }
}

class MergeSortingAppUser {
    public static void main(String[] args) {
        MergeSortingApp array = new MergeSortingApp(100);
        array.fillWithRandoms();
        array.show();
        System.out.println();
        array.sortArray();
        array.show();
    }
}