package com.company;

public class Validator {

    public static boolean isValid(String s) throws Exception {

        String regexNum = "[\\d\\s\\(\\)]";
        String regexZnak = "[\\-\\/\\*\\+]";
        int countNum = 0;
        int countZnak = 0;
        int countSkobka = 0;


        for (String c : s.split(regexNum)) {
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^")) {
                countZnak++;
            } else if (c.equals("")) {
                continue;
            } else {
                for (char z : c.toCharArray()) {
                    if (Calc.getPriority(z) > 0) {
                        countZnak++;
                    }
                }

            }
        }
        for (char c : s.toCharArray()) {
            if (c == '(' || c == ')') {
                countSkobka++;
            }
        }
        for (String c : s.split(regexZnak)) {
            if (c.equals("")) {
                continue;
            } else {
                countNum++;
            }
        }
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Некорректный ввод выражения! Пустая строка!");
        }
        if (countNum <= countZnak) {
            throw new IllegalArgumentException("Некорректный ввод выражения! Провертье правильность расположения операторов!");
        }
        if (countNum == 1) {
            throw new IllegalArgumentException("Некорректный ввод выражения!");
        }
        if (countSkobka % 2 != 0) {
            throw new IllegalArgumentException("Некорректный ввод выражения! Проверьте правильность расположения скобок!");
        }

        return true;
    }
}
