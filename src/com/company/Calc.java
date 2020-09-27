package com.company;

import java.util.Stack;

public class Calc {

    public static String ReversePolishNotation(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int priority = getPriority(s.charAt(i));
            if (priority == 0) {
                result.append(s.charAt(i));
            } else if (priority == 1) {
                stack.push((s.charAt(i)));
            } else if (priority > 1) {
                result.append(" ");
                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= priority) {
                        result.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(s.charAt(i));
            } else if (priority == -1) {
                result.append(" ");
                while (getPriority(stack.peek()) != 1) {
                    result.append(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.empty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static Double getAnswer(String s) {
        Stack<Double> stack = new Stack<>();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (getPriority(s.charAt(i)) == 0) {
                while (s.charAt(i) != ' ' && getPriority(s.charAt(i)) == 0) {

                    string.append(s.charAt(i++));

                }
                stack.push(Double.parseDouble(string.toString()));
                string = new StringBuilder("");
            }
            if (getPriority(s.charAt(i)) > 1) {
                double a = stack.pop();
                double b = stack.pop();

                if (s.charAt(i) == '+') {
                    stack.push(b + a);
                }
                if (s.charAt(i) == '-') {
                    stack.push(b - a);
                }
                if (s.charAt(i) == '/') {
                    if (a == 0 || a == 0.0) {
                        throw new ArithmeticException("Ошибка, деление на 0!");
                    } else {
                        stack.push(b / a);
                    }
                }
                if (s.charAt(i) == '*') {
                    stack.push(b * a);
                }
                if (s.charAt(i) == '^') {
                    stack.push(Math.pow(b, a));
                }
            }

        }
        return stack.pop();
    }

    public static int getPriority(char c) {
        if (c == '^') {
            return 4;
        } else if (c == '*' || c == '/') {
            return 3;
        } else if (c == '+' || c == '-') {
            return 2;
        } else if (c == '(') {
            return 1;
        } else if (c == ')') {
            return -1;
        } else
            return 0;
    }
}