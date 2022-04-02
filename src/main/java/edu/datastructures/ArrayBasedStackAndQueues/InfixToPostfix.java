package edu.datastructures.ArrayBasedStackAndQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InfixToPostfix {
    private String expression;
    private String postfixExpression;
    private ArrayBracketsCheckerStack operatorsStack;
    private ArrayStackApp numStack;

    InfixToPostfix(String expression) {
        this.expression = expression.replaceAll(" ", "");
        operatorsStack = new ArrayBracketsCheckerStack(expression.length());
        numStack = new ArrayStackApp(expression.length());
    }

    public String convert() throws StackException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char thisElem = expression.charAt(i);
            switch (thisElem) {
                case '+':
                case '-':
                    while (!operatorsStack.isEmpty() && operatorsStack.peek() != '(') {
                        sb.append(operatorsStack.pop());
                    }
                    operatorsStack.push(thisElem);
                    break;
                case '*':
                case '/':
                    if (!operatorsStack.isEmpty() && (operatorsStack.peek() == '*' || operatorsStack.peek() == '/')) {
                        sb.append(operatorsStack.pop());
                        operatorsStack.push(thisElem);
                    } else {
                        operatorsStack.push(thisElem);
                    }
                    break;
                case '(':
                    operatorsStack.push(thisElem);
                    break;
                case ')':
                    while (operatorsStack.peek() != '(') {
                        sb.append(operatorsStack.pop());
                    }
                    operatorsStack.pop();
                    break;
                default:
                    sb.append(thisElem);
            }
        }

        while (!operatorsStack.isEmpty()) {
            sb.append(operatorsStack.pop());
        }
        postfixExpression = sb.toString();
        return postfixExpression;
    }

    //только для однозначных чисел
    public long calculatePostfix() throws Exception {
        convert();
        long num;
        for (int i = 0; i < postfixExpression.length(); i++) {
            char thisElem = postfixExpression.charAt(i);
            switch (thisElem) {
                case '+':
                    num = numStack.pop() + numStack.pop();
                    numStack.push(num);
                    break;
                case '-':
                    num = numStack.pop();
                    numStack.push(numStack.pop() - num);
                    break;
                case '*':
                    num = numStack.pop() * numStack.pop();
                    numStack.push(num);
                    break;
                case '/':
                    num = numStack.pop();
                    numStack.push(numStack.pop() / num);
                    break;
                default:
                    numStack.push(thisElem - '0');
            }
        }
        return numStack.pop();
    }
}

class InfixToPostfixUser {
    public static void main(String[] args) throws Exception {
        InfixToPostfix ip1 = new InfixToPostfix("A + B * (C - D/(E + F))");
        System.out.println(ip1.convert());

        while (true) {
            System.out.println("Enter an arithmetical expression to convert it into postfix form: ");
            System.out.flush();

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String expression = br.readLine();

            if (expression.equals("")) break;

            InfixToPostfix ip2 = new InfixToPostfix(expression);
            System.out.println(ip2.convert());
            System.out.println("Answer: " + ip2.calculatePostfix());
        }
    }
}