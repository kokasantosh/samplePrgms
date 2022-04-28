package com.sample.dp;

import java.util.*;

public class BestSum {

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 25};
        Map<Integer, ArrayList<Integer>> memo = new HashMap<>();
        System.out.println("Best Sum: " + bestSum(a, 100, memo));
//        memo = new HashMap<>();
//        System.out.println("Best Sum: " + bestSum(a, 300, memo));

        System.out.println("Best Sum: " + bestSumTabulation(a, 100));
        a = new int[] {7, 14};
        System.out.println("Best Sum: " + bestSumTabulation(a, 21));
    }

    private static ArrayList<Integer> bestSum(int[] input, int target, Map<Integer, ArrayList<Integer>> memo) {

        if(memo.containsKey(target)) { return memo.get(target);}
        if(target==0) { return new ArrayList<>(); } if(target < 0) { return null;}

        ArrayList<Integer> shortestCombination = null;

        for(int num: input) {
            int remainder = target - num;

            ArrayList<Integer> combinationRemainder = bestSum(input, remainder, memo);

            if(combinationRemainder != null) {
                ArrayList<Integer> combination = new ArrayList<>(combinationRemainder);
                combination.add(num);
                if(shortestCombination == null || shortestCombination.size() > combination.size()) {
                    shortestCombination = combination;
                }
            }
        }

        memo.put(target, shortestCombination);
        return shortestCombination;

    }

    private static ArrayList<Integer> bestSumTabulation(int[] input, int target) {
        ArrayList<ArrayList<Integer>> table = new ArrayList<>(Collections.nCopies(target + 1, null));
        table.set(0, new ArrayList<>());

        for(int i = 0; i < target; i ++) {
            if(table.get(i) != null) {
                for(int j = 0; j < input.length; j++) {
                    if(i + input[j] <= target && (table.get(i + input[j]) == null || table.get(i + input[j]).size() > table.get(i).size())) {
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
