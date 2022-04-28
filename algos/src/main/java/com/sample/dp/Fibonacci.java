package com.sample.dp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(calcFibonacci(50, new HashMap<>()));

        System.out.println(calcFibonacciTabulation(6));
    }

    private static BigDecimal calcFibonacci(int n, Map<Integer, BigDecimal> memo) {
        if(n <= 0) { return BigDecimal.ZERO;} else if(n <= 2) { return BigDecimal.ONE;}
        if(memo.containsKey(n)) { return memo.get(n);}
        memo.put(n, calcFibonacci(n-1, memo).add(calcFibonacci(n-2, memo)));
        return memo.get(n);
    }

    private static int calcFibonacciTabulation(int n) {
        int[] resultArray = new int[n + 1];
        Arrays.fill(resultArray, 0);
        resultArray[1] = 1;

        for(int i = 0; i < n; i ++) {
            resultArray[i + 1] += resultArray[i];
            if(i + 2 <= n)
                resultArray[i + 2] += resultArray[i];
        }

        return resultArray[n];
    }
}
