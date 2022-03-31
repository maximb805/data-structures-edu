package edu.datastructures.Arrays;


public class SortedArrayApp {
    private long[] array;
    private int numAmount;

    SortedArrayApp(int size) {
        array = new long[size];
        numAmount = 0;
    }

    public long[] fillWithRandoms(int numAmount) {
        int checker;
        for (int i = 0; i < numAmount; ) {
            checker = this.numAmount;

            add((long) (Math.random() * 100));

            if (checker == this.numAmount) ;
            else i++;
        }
        return array;
    }

    public void add(long num) {
        if (numAmount == array.length) {
            System.out.println("Array's full");
        } else {
            if (numAmount > 0) {
                int index = binarySearchRealisation(num, 0, numAmount - 1);
                if (index > -1) {
                    System.out.println(num + " is already defined in the array");
                    return;
                } else {
                    int i = numAmount;
                    while (i > 0 && array[i - 1] > num) {
                        array[i] = array[i - 1];
                        i--;
                    }
                    array[i] = num;
                }
            } else {
                array[numAmount] = num;
            }
            numAmount++;
        }
    }

    public long getElem(int index) {
        return array[index];
    }

    public void delete(long num) {
        int index = binarySearchRealisation(num, 0, numAmount - 1);
        if (index < 0) {
            System.out.println(num + " wasn't in the array");
        } else {
            for (int i = index; i < numAmount - 1; i++) {
                array[i] = array[i + 1];
            }
            System.out.println(num + " deleted from the array");
        }
    }

    public void linearSearch(long num) {
        int i;
        for (i = 0; i < numAmount; i++) {
            if (array[i] == num) {
                System.out.println(num + " found at [" + i + "]");
                return;
            }
            if (array[i] > num) {
                System.out.println(num + " not found");
                return;
            }
        }
        if (i == numAmount) {
            System.out.println(num + " not found");
        }
    }

    public void binarySearch(long num) {
        int index = binarySearchRealisation(num, 0, numAmount - 1);
        if (index > -1) {
            System.out.println(num + " found at [" + index + "]");
        } else {
            System.out.println(num + " not found");
        }
    }

    private int binarySearchRealisation(long num, int min, int max) {
        int med = (max + min) / 2;
        if (array[med] == num) {
            return med;
        }
        if (max - min < 1) {
            return -1;
        } else {
            if (array[med] < num) {
                return binarySearchRealisation(num, med + 1, max);
            } else {
                return binarySearchRealisation(num, min, med - 1);
            }
        }
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

    public static long[] merge(long[] array1, long[] array2) {
        long[] mergedArray = new long[array1.length + array2.length];
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < mergedArray.length; i++) {
            if (index1 < array1.length && index2 < array2.length) {
                if (array1[index1] < array2[index2]) {
                    mergedArray[i] = array1[index1];
                    index1++;
                } else {
                    mergedArray[i] = array2[index2];
                    index2++;
                }
            } else {
                if (index1 < array1.length) {
                    mergedArray[i] = array1[index1];
                    index1++;
                } else {
                    mergedArray[i] = array2[index2];
                    index2++;
                }
            }
        }
        return mergedArray;
    }
}

class SortedArrayAppUser {
    public static void main(String[] args) {
        SortedArrayApp sortedArray = new SortedArrayApp(50);

        sortedArray.fillWithRandoms(30);
        sortedArray.show();

        sortedArray.linearSearch(17);
        System.out.println(sortedArray.getElem(7));
        sortedArray.delete(30);
        sortedArray.show();
        System.out.println();

        sortedArray.add(100);
        sortedArray.add(1);
        sortedArray.add(18);
        sortedArray.show();
        System.out.println();

        sortedArray.linearSearch(100);
        sortedArray.linearSearch(1);
        sortedArray.linearSearch(18);

        sortedArray.binarySearch(18);
        sortedArray.binarySearch(17);
        System.out.println();

        sortedArray.delete(18);
        sortedArray.delete(100);
        sortedArray.delete(121);
        sortedArray.show();
        System.out.println();

        long[] sortedArray1 = new SortedArrayApp(30).fillWithRandoms(30);
        long[] sortedArray2 = new SortedArrayApp(12).fillWithRandoms(12);
        long[] mergedArray = SortedArrayApp.merge(sortedArray1, sortedArray2);

        for (int i = 0; i < mergedArray.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (i == mergedArray.length - 1) {
                System.out.println(mergedArray[i] + "]");
            } else {
                System.out.print(mergedArray[i] + ", ");
            }
        }
    }
}
