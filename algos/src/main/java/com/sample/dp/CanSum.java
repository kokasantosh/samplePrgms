package com.sample.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        int[] a = {7, 14};
        Map<Integer, Boolean> memo = new HashMap<>();
        System.out.println("Can Sum: " + canSum(a, 300, memo));
        memo = new HashMap<>();
        System.out.println("Can Sum: " + canSum(a, 21, memo));

        System.out.println("Can Sum: " + canSumTabulation(a, 21));
    }

    private static boolean canSum(int[] input, int target, Map<Integer, Boolean> memo) {
        if(memo.containsKey(target)) { return memo.get(target);}
        if(target == 0) { return true; }
        if(target < 0) { return false; }

        for(int num : input) {
            if(canSum(input, target - num, memo)) { memo.put(target, true); return true;}
        }
        memo.put(target, false);
        return false;
    }

    private static boolean canSumTabulation(int[] input, int target) {
        Boolean[] table = new Boolean[target + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for(int i = 0; i <= target; i ++) {
            if(table[i]) {
                for (int j = 0; j < input.length; j++) {
                    if (i + input[j] <= target) {
                        table[i + input[j]] = true;
                    }
                }
            }
        }

        return table[target];
    }
}
