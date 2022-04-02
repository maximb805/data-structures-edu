package edu.datastructures.ArrayBasedStackAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayBracketsCheckerStack {
    private int maxSize;
    private char[] stack;
    private int top;

    public ArrayBracketsCheckerStack(int size) {
        maxSize = size;
        stack = new char[maxSize];
        top = -1;
    }

    public void push(char num) throws StackException {
        if (top == maxSize - 1)
            throw new StackException("Stack's full");

        stack[++top] = num;
    }

    public char pop() throws StackException {
        if (top < 0)
            throw new StackException("Stack's empty");

        return stack[top--];
    }

    public char peek() throws StackException {
        if (top < 0)
            throw new StackException("Stack's empty");

        return stack[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class BracketChecker {
    private String input;

    BracketChecker(String input) {
        this.input = input;
    }

    public void check() {
        int stackSize = input.length();
        ArrayBracketsCheckerStack stack = new ArrayBracketsCheckerStack(stackSize);
        try {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                switch (ch) {
                    case '{':
                    case '[':
                    case '(':
                        stack.push(ch);
                        break;
                    case '}':
                    case ']':
                    case ')':
                        if (!stack.isEmpty()) {
                            char chx = stack.pop();
                            if (chx == '{' && ch != '}' ||
                                    chx == '[' && ch != ']' ||
                                    chx == '(' && ch != ')') {
                                System.err.println("Error: " + ch + " on " + chx + " at " + i);
                            }
                        } else {
                            System.err.println("Error: " + ch + " has no opening delimiter!");
                        }
                        break;
                    default:
                        break;
                }
            }
            if (!stack.isEmpty()) {
                System.err.print("Error: missing closing delimiter(s) for: ");
                while (!stack.isEmpty()) {
                    System.err.println(stack.pop());
                }
            }
        } catch (StackException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class ArrayBracketCheckerUser {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Enter string containing delimiters: ");
            System.out.flush();

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String input = br.readLine();

            if (input.equals("")) break;

            BracketChecker checker = new BracketChecker(input);
            checker.check();
        }
    }
}
