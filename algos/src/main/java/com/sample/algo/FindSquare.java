package com.sample.algo;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FindSquare {

    public static void main(String[] args){
        int A = 10;
        int B = 20;

        // solution should be 2;
        System.out.println(findSquare(A, B, 2, 2, new TreeMap<Integer, Integer>())
//                .values()
//                .stream()
//                .max(Comparator.comparing(Integer::valueOf)).get()
        );

    }


    private static Map<Integer, Integer> findSquare(int A, int B, int sqr, int power, Map<Integer, Integer> map) {
        power = new Double(Math.pow(sqr, 2)).intValue();
        int count = 1;
        while (power <= A || power <= B ) {
            power = new Double(Math.pow(power, 2)).intValue();
            if(power >= A && power >= B) {
                findSquare(A, B, ++sqr, new Double(Math.pow(sqr, 2)).intValue(), map);
            }
            count++;
            if(power >= A && power <= B) {
                map.put(sqr, count);
            }

        }
        return map;
    }
}
