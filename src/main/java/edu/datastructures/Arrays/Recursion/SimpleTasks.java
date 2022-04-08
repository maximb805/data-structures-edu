package edu.datastructures.Arrays.Recursion;

import edu.datastructures.ArrayBasedStackAndQueues.StackException;

public class SimpleTasks {
    static char[][] treeArray;
    static int rowCount = 0, rowLength = 0;

    public static void main(String[] args) throws StackException {
//        System.out.println(triangle(10));
//        System.out.println(factorial(5));
//        System.out.println(pow(5, 16));
//        System.out.println();
//        System.out.println(mult(80, 5));
        makeBranches(6);
        displayTree();
    }

    private static int mult(int x, int y) {
        return y == 1 ? x : x + mult(x, y - 1);
    }

    static int pow(int x, int y) {
        int result = x;
        if (y == 1)
            return result;
        result = pow(x * x, y / 2);
        if (y % 2 == 1) {
            result = result * x;
        }
        return result;
    }

    static int triangle(int num) {
        return num == 1 ? num : num + triangle(num - 1);
    }

    static long factorial(long num) {
        return num == 0 ? 1 : num * factorial(num - 1);
    }

    static void makeBranches(int rows) {
        rowCount = rows;
        rowLength = pow(2, rowCount);
        treeArray = new char[rowCount][rowLength];
        treeCreate(0, rowLength-1, 0);
    }

    static void treeCreate(int left, int right, int row) {
        if (row == rowCount)
            return;
        treeCreate((left + right)/2, right, row + 1);
        for (int i = left; i <= right; i++) {
            if (treeArray[row][i] == '\u0000')
            if (i == (left + right) / 2)
                treeArray[row][i] = 'X';
            else
                treeArray[row][i] = '-';
        }
        treeCreate(left, (left + right) / 2, row + 1);
        for (int i = left; i <= right; i++) {
            if (treeArray[row][i] == '\u0000')
            if (i == (left + right) / 2)
                treeArray[row][i] = 'X';
            else
                treeArray[row][i] = '-';
        }
    }

    static void displayTree() {
        for (char[] c : treeArray) {
            System.out.println(c);
        }
    }
}
