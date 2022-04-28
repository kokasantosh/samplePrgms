package com.sample.dp;

import java.util.HashMap;

public class CountConstruct {

    public static void main(String[] args) {
//        String[] input = {"ab", "abc", "cd", "def", "abcd"};
//        HashMap<String, Integer> memo = new HashMap<>();
//        System.out.println("Count Construct: " + countConstruct(input, "abcdef", memo));

        String[] input = {"purp", "p", "ur", "le", "purpl"};
        HashMap<String, Integer> memo = new HashMap<>();
        System.out.println("Count Construct: " + countConstruct(input, "purple", memo));
    }

    private static Integer countConstruct(String[] input, String target, HashMap<String, Integer> memo) {
        if(memo.containsKey(target)) { return memo.get(target); }

        if(target == null || target.length() == 0) { return 1; }

        int res = 0;

        for(String val : input) {
            if(target.startsWith(val)) {
                res += countConstruct(input, target.replaceFirst(val, ""), memo);
            }
        }

        memo.put(target, res);
        return res;
    }
}
