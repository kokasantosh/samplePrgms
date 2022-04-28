package com.sample.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        int[] a = {7, 14};
        Map<Integer, ArrayList<Integer>> memo = new HashMap<>();
        System.out.println("How Sum: " + howSum(a, 21, memo));
        memo = new HashMap<>();
        System.out.println("How Sum: " + howSum(a, 300, memo));

        System.out.println("How Sum: " + howSumTabulation(a, 21));
    }

    private static ArrayList<Integer> howSum(int[] input, int target, Map<Integer, ArrayList<Integer>> memo) {
        if(memo.containsKey(target)) { return memo.get(target); }
        if(target == 0) { return new ArrayList<>();} else if(target < 0) { return null;}

        for(int val: input) {
          ArrayList<Integer> res = howSum(input, target-val, memo);
          if(res != null) {
              res.add(val);
              memo.put(target, res);
              return res;
          }
        }
        memo.put(target, null);
        return null;
    }

    private static ArrayList<Integer> howSumTabulation(int[] input, int target) {
        ArrayList<ArrayList<Integer>> table = new ArrayList<>(Collections.nCopies(target + 1, null));
        table.set(0, new ArrayList<>());

        for(int i = 0; i < target; i ++) {
            if(table.get(i) != null) {
                for(int j = 0; j < input.length; j++) {
                    if(i + input[j] <= target) {
                        ArrayList<Integer> val = new ArrayList<>(table.get(i));
                        val.add(input[j]);
                        table.set(i + input[j], val);
                    }
                }
            }
        }

        return table.get(target);
    }
}
