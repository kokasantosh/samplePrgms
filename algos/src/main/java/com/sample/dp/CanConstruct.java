package com.sample.dp;

import java.util.Arrays;
import java.util.HashMap;

public class CanConstruct {

    public static void main(String[] args) {
        String[] input = {"ab", "abc", "cd", "def", "abcd"};
        HashMap<String, Boolean> memo = new HashMap<>();
        System.out.println("CanConstruct: " + canConstruct(input, "abcdef", memo));

        System.out.println("CanConstruct: " + canConstructTabulation(input, "abcdef"));

    }

    private static boolean canConstruct(String[] input, String target, HashMap<String, Boolean> memo) {

        if(memo.containsKey(target)) { return memo.get(target); }

        if(target == null || target.length() == 0) { return true; }

        for(String val: input) {
            if(target.startsWith(val)) {
                if(canConstruct(input, target.replaceFirst(val, ""), memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }

    private static boolean canConstructTabulation(String[] input, String target) {
        Boolean[] table = new Boolean[target.length() + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for(int i = 0; i <= target.length(); i++) {
            if(table[i]) {
                for(int j = 0; j < input.length; j++) {
                    if(target.substring(i).startsWith(input[j])) {
                        table[i + input[j].length()] = true;
                    }
                }
            }
        }

        return table[target.length()];
    }
}
