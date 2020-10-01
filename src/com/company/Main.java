package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        Read r = new Read();
        Calc calc = new Calc();


        while (true) {
            System.out.println("Введите выражение: ");
            String s = r.handleString(r.read());
            if (Validator.isValid(s)){
                System.out.println("Ответ: " + calc.getAnswer(calc.ReversePolishNotation(s)));
            }

        }
    }
}
