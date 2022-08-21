package com.sample.algo;

import java.util.ArrayList;

public class AddNumbers {

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();

        array.add("abc");
        array.add("abc");
        array.add("abc");
        array.add("abc");

        for(String s: array) {
            System.out.println(s);
            array.add("def");
        }
    }

}
