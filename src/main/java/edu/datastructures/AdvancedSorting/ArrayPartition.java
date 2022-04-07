package edu.datastructures.AdvancedSorting;

public class ArrayPartition {
    private int[] array;

    ArrayPartition(int size) {
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    public int partitionIt(int borderValIndex) {
        int left = 0;
        int right = array.length - 1;
        int leftB = left - 1;
        int rightB = right + 1;
        int pivot = array[borderValIndex];
        System.out.println("Pivot is: " + array[borderValIndex]);
        while (true) {
            while (leftB < right && array[++leftB] < pivot)
                ;
            while (rightB > left && array[--rightB] > pivot)
                ;
            if (rightB <= leftB)
                break;
            else {
                swap(leftB, rightB);
            }
        }
        System.out.println("Array partition at index: " + leftB);
        return leftB;
    }

    public int getMedian() {
        return median(array.length - 1, 0, array.length - 1);
    }

    private int median(int index, int left, int right) {
        index = partitionIt(index);
        if (index == array.length / 2) {
            System.out.println("Median is: " + array[index]);
            return array[index];
        }
        if (right - left <= 2) {
            int result = manualChoose(left, right, array.length / 2);
            System.out.println("Median is: " + array[index]);
            return result;
        } else {
            if (index < array.length / 2) {
                left = left >= index ? left + 1 : index;
            } else {
                right = right <= index ? right - 2 : index - 1;
            }
            index = (int) ((Math.random() * (right - left - 1)) + left + 1);
            return median(index, left, right);
        }
    }

    //returns (elementNumber)th largest element
    public int getLargestOf(int elemNumber) {
        return getElem(array.length - 1, 0, array.length - 1, elemNumber);
    }

    private int getElem(int index, int left, int right, int elemNumber) {
        index = partitionIt(index);
        if (index == elemNumber - 1) {
            System.out.println(elemNumber + "'s element: " + array[index]);
            return array[index];
        }
        if (right - left <= 2) {
            int result = manualChoose(left, right, elemNumber - 1);
            System.out.println(elemNumber + "'s element: " + result);
            return result;
        } else {
            if (index < elemNumber) {
                left = left >= index ? left + 1 : index;
            } else {
                right = right <= index ? right - 2 : index - 1;
            }
            index = (int) ((Math.random() * (right - left)) + left);
            return getElem(index, left, right, elemNumber);
        }
    }

    private int manualChoose(int left, int right, int index) {
        if (left - right == 0) {
            return array[left];
        }
        if (left - right == 1) {
            if (array[left] > array[right])
                swap(left, right);
        } else {
            if (array[left] > array[left + 1])
                swap(left, left + 1);
            if (array[left] > array[right])
                swap(left, right);
            if (array[left + 1] > array[right])
                swap(left + 1, right);
        }
        return array[index];
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        ;
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

class ArrayPartitionUser {
    public static void main(String[] args) {
        ArrayPartition partArray = new ArrayPartition(100);
        partArray.display();

        partArray.getLargestOf(9);
        partArray.display();

        partArray.getMedian();
        partArray.display();
    }
}