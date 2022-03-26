package edu.datastructures.Arrays;

public class SortedArrayApp {
    private long[] array;
    private int numAmount = 0;

    SortedArrayApp(int size) {
        array = new long[size];
    }

    public void fillWithRandoms(int numAmount) {
        int checker;
        for (int i = 0; i < numAmount; ) {
            checker = this.numAmount;

            add((long) (Math.random() * 100));

            if (checker == this.numAmount) ;
            else i++;
        }
    }

    public void add(long num) {
        if (numAmount == array.length) {
            System.out.println("Array's full");
        } else {
            if (numAmount > 0) {
                for (int i = 0; i < numAmount; i++) {
                    if (array[i] == num) {
                        System.out.println("This number is already defined in the array");
                        return;
                    }
                }
                for (int i = numAmount; i > 0; i--) {
                    if (array[i - 1] < num) {
                        array[i] = num;
                        break;
                    } else {
                        array[i] = array[i - 1];
                        if (i == 1) {
                            array[i - 1] = num;
                        }
                    }
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
        int i;
        for (i = 0; i < numAmount; i++) {
            if (array[i] == num) {
                for (int j = i; j < numAmount - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[numAmount - 1] = 0;
                numAmount--;
                System.out.println(num + " deleted from the array");
                return;
            }
            if (array[i] > num) {
                System.out.println(num + " wasn't in the array");
                return;
            }
        }
        if (i == numAmount) {
            System.out.println(num + " wasn't in the array");
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

        sortedArray.add(100);
        sortedArray.add(1);
        sortedArray.add(18);
        sortedArray.show();

        sortedArray.linearSearch(100);
        sortedArray.linearSearch(1);
        sortedArray.linearSearch(18);

        sortedArray.binarySearch(18);
        sortedArray.binarySearch(17);
    }
}
