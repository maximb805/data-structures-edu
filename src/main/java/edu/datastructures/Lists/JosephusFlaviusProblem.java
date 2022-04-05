package edu.datastructures.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class JosephusFlaviusProblem
{
    private CyclicListApp list;
    private int step, manCount;

    JosephusFlaviusProblem(int manCount, int startNum, int step) {
        list = new CyclicListApp();
        this.step = step - 1;
        this.manCount = manCount;
        for (int i = 1; i <= manCount; i++) {
            list.insert(i);
            list.step();
        }
        for(int i = 1; i <= startNum; i++)
            list.step();
    }

    public int getSolution() {
        Integer solution;
        for(int i = 0; i < manCount - 1; i++) {
            for (int j = 1; j < step; j++) {
                list.step();
            }
            list.deleteNext();
            list.step();
        }
        solution = (Integer) list.getCurrent().getData();
        return solution;
    }
}

class JosephusFlaviusProblemSolution {
    public static void main(String[] args) throws IOException {

        int step, manCount, startNum;

        System.out.println("Enter 0 to exit");
        while (true) {
            try {
                System.out.print("Enter man count: ");
                System.out.flush();
                manCount = getNum();
                if (manCount == 0)
                    break;

                System.out.print("Enter start num: ");
                System.out.flush();
                startNum = getNum();
                if (startNum > manCount) {
                    throw new MyException("Start num can't be greater than man count");
                }
                if (startNum == 0)
                    break;

                System.out.print("Enter step count: ");
                System.out.flush();
                step = getNum();
                if (step == 0)
                    break;

                JosephusFlaviusProblem sol = new JosephusFlaviusProblem(manCount, startNum, step);
                System.out.println(sol.getSolution());

            } catch (MyException ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Is that an int num?");
            }
        }
    }

    public static int getNum() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return Integer.parseInt(br.readLine());
    }
}

