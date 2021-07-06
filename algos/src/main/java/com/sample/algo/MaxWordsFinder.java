package com.sample.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxWordsFinder {

    public static void main(String[] args) {
        String s = "Hello  world. Yes   This is max words   String";

        List<String> lines = Arrays.asList(s.split("\\."));

        int[] max = {0};

        lines.forEach(line -> {
            List<String> words = new ArrayList<>(Arrays.asList(line.split(" ")));

            words.removeIf(word -> {word = word.trim(); return word.isEmpty() || "?".equals(word) || "!".equals(word);});

            max[0] = words.size()> max[0] ?words.size(): max[0];
        });

        System.out.println(max[0]);

    }
}
