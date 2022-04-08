package edu.datastructures.Arrays.Recursion;

public class Towers {
    private static int counter = 0;

    public static void doTowers(int discCount) {
        doTowers(discCount, 'A', 'B', 'C');
    }

    private static void doTowers(int discCount, char from, char inter, char to) {
        if (discCount == 1) {
            counter++;
            System.out.println(counter + ") Disk 1 from " + from + " to " + to);
        } else {
            doTowers(discCount - 1, from, to, inter);
            counter++;
            System.out.println(counter + ") Disk " + discCount + " from " + from + " to " + to);
            doTowers(discCount - 1, inter, from, to);
        }
    }

    public static void main(String[] args) {
        doTowers(7);
    }
}
