package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Read {
    public String read() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        return s;
    }

    public String handleString(String s) {
        s = s.replaceAll("\\s", "");
        return s;
    }
}