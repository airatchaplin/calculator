package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Read {
    public static String read() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String regexNum = "[\\d\\s\\(\\)]";
        String regexZnak = "[\\-\\/\\*\\+]";
        int countNum = 0;
        int countZnak = 0;

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
        for (String c : s.split(regexZnak)) {
            if (c.equals("") || c.equals(" ")) {
                continue;
            } else {
                countNum++;
            }
        }
        if (countNum <= countZnak) {
            throw new Exception("Некорректный ввод выражения!");
        }
        return s;
    }
}
