package edu.datastructures.Recursion;

import edu.datastructures.ArrayBasedStackAndQueues.StackException;

public class SimpleTasks {
    public static void main(String[] args) throws StackException {
        System.out.println(triangle(5));
        System.out.println(factorial(5));
        System.out.println(pow(5, 16));
        System.out.println();
    }

    static long pow(long x, long y) {
        long result = x;
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

}
