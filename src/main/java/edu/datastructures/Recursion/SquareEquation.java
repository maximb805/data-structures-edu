package edu.datastructures.Recursion;


import java.text.DecimalFormat;
import java.util.Scanner;

class CantExtractRootException extends Exception {

    CantExtractRootException(String message) {
        super(message);
    }
}

class SquareESolution {
    static double[] sqSolution(double a, double b, double c) {
        double[] x = new double[0];

        try {
            double D = multiply(b, 2) - (4 * a * c);
            if (D == 0)
                x = new double[]{((-b + root(D, 2)) / (2 * a))};
            if (D > 0)
                x = new double[]{((-b + root(D, 2)) / (2 * a)), ((-b - root(D, 2)) / (2 * a))};
        } catch (CantExtractRootException e) {
            System.out.println(e.getMessage());
        }
        return x;
    }

    //count - значение под корнем, rootVal - степень корня.
    static double root(double count, int rootVal) throws CantExtractRootException {
        double min;
        double max;
        if (rootVal % 2 == 0 && count < 0) {
            System.out.println();
            throw new CantExtractRootException("Ошибка! Невозможно извлечь корень.");
        }
        if (count == 0) return count;
        if (count <= -1) {
            min = count;
            max = -1;
        } else {
            if (count > -1 && count < 0) {
                min = -1;
                max = 0;
            } else {
                if (count > 0 && count < 1) {
                    min = 0;
                    max = 1;
                } else {
                    min = 1;
                    max = count;
                }
            }
        }
        return binSearch(min, max, rootVal, count);
    }

    private static double binSearch(double min, double max, int rootVal, double count) {
        double mid = (max + min) / 2;
        double check = mid;
        if (max - min < 0.0000000000000000001) return mid;

        for (int i = 2; i <= rootVal; i++) {
            check *= mid;
        }
        if (check == count) return mid;

        if (check > count) {
            try {
                return binSearch(min, mid, rootVal, count);
            } catch (StackOverflowError soe) {
                return mid;
            }
        } else {
            try {
                return binSearch(mid, max, rootVal, count);
            } catch (StackOverflowError soe) {
                return mid;
            }
        }
    }

    //count - число, возводимое в степень, multVal - степень.
    static double multiply(double count, int multVal) {
        double multiplier = count;

        for (int i = 2; i <= multVal; i++) {
            multiplier *= count;
        }
        return multiplier;
    }
}

public class SquareEquation {
    public static void main(String[] args) {
        DecimalFormat dF = new DecimalFormat("#.#####");

        System.out.println("Решение квадратного уравнения (a * x^2 + b * x + c = 0)");

        System.out.print("Введите число а: ");
        double a = new Scanner(System.in).nextDouble();
        System.out.print("Введите число b: ");
        double b = new Scanner(System.in).nextDouble();
        System.out.print("Введите число c: ");
        double c = new Scanner(System.in).nextDouble();

        double[] sol = SquareESolution.sqSolution(a, b, c);
        if (sol.length == 1) {
            System.out.println("x = " + sol[0]);
        } else {
            if (sol.length == 2) {
                System.out.println("x1 = " + sol[0] + "\nx2 = " + sol[1]);
            } else {
                System.out.println("Нет корней");
            }
        }

        //ниже тест работы вичислителя корней
        double count = -256;
        int rootVal = 3;
        double x;
        try {
            x = SquareESolution.root(count, rootVal);
            System.out.println("\nКорень " + rootVal + "-й степени из " + count + " = " + dF.format(x));
            System.out.println("Проверка: " + dF.format(SquareESolution.multiply(x, rootVal)));
        } catch (CantExtractRootException e) {
            System.out.println(e.getMessage());
        }
    }
}