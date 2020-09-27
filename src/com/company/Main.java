package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        while (true) {
            System.out.println("Введите выражение: ");
            System.out.println("Ответ: " + Calc.getAnswer(Calc.ReversePolishNotation(Read.read())));
        }
    }
}
