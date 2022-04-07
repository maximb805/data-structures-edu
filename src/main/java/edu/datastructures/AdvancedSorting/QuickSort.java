package edu.datastructures.AdvancedSorting;

public class QuickSort {
    private int[] array;
    private int copyingCount, comparingCount;

    QuickSort(int size) {
        array = new int[size];
    }

    public int partitionIt(int left, int right, int borderVal) {
        int leftB = left;
        int rightB = right - 1;
        while (true) {
            while (array[++leftB] < borderVal)
                comparingCount++;
            comparingCount++;
            while (array[--rightB] > borderVal)
                comparingCount++;
            comparingCount++;
            if (rightB <= leftB)
                break;
            else {
                swap(leftB, rightB);
            }
        }
        swap(leftB, right - 1);
        return leftB;
    }

    public void quickSort() {
        copyingCount = comparingCount = 0;
        qSort(0, array.length - 1);
        System.out.println("Copying count: " + copyingCount + ", Comparing count: " + comparingCount);
    }

    private void qSort(int left, int right) {
        if (right - left + 1 <= 3)
            manualSort(left, right);
//        if (right - left + 1 < 10)
//            insertionSort(left, right);
        else {
            int med = medianOf3(left, right);
            int partition = partitionIt(left, right, med);
            qSort(left, partition - 1);
            qSort(partition + 1, right);
        }
    }

    private int medianOf3(int left, int right) {
        int med = (left + right) / 2;
        comparingCount += 3;
        if (array[left] > array[med]) {
            swap(left, med);
        }
        if (array[left] > array[right]) {
            swap(left, right);
        }
        if (array[med] > array[right]) {
            swap(med, right);
        }
        swap(med, right - 1);
        return array[right - 1];
    }

    private void insertionSort(int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            copyingCount++;
            int buffer = array[i];
            int j = i;
            while (j > left && array[j - 1] >= buffer) {
                copyingCount++;
                array[j] = array[j - 1];
                j--;
            }
            comparingCount++;
            copyingCount++;
            array[j] = buffer;
        }
    }

    private void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            comparingCount++;
            if (array[left] > array[right])
                swap(left, right);
        } else {
            comparingCount += 3;
            if (array[left] > array[right - 1]) {
                swap(left, right - 1);
            }
            if (array[left] > array[right]) {
                swap(left, right);
            }
            if (array[left + 1] > array[right]) {
                swap(left + 1, right);
            }
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        copyingCount += 3;
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

class QuickSortUser {
    public static void main(String[] args) {
        QuickSort array = new QuickSort(100);
        array.fillWithRandoms();
        array.display();
        System.out.println();
        array.quickSort();
        array.display();
        array.quickSort();
        array.display();
//        array.fillWithRandoms();
//        array.display();
    }
}
