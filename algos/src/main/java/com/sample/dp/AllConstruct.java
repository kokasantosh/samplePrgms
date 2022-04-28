package com.sample.dp;

import java.util.ArrayList;

public class AllConstruct {

    public static void main(String[] args) {
        String[] input = {"purp", "p", "ur", "le", "purpl"};
//        HashMap<String, Integer> memo = new HashMap<>();
        System.out.println("All Construct: " + allConstruct(input, "purple"));
    }

    private static ArrayList<ArrayList<String>> allConstruct(String[] input, String target) {
        if(target == null || target.length() == 0) { return new ArrayList<ArrayList<String>>();}

        ArrayList<ArrayList<String>> result = null;
        for(String val : input) {
            if(target.startsWith(val)) {
                ArrayList<ArrayList<String>> suffixWays = allConstruct(input, target.replaceFirst(val, ""));
                if(suffixWays != null) {
                    if(result == null) { result = new ArrayList<>(); }
                    suffixWays.stream().map(way -> way.add(val));
                    if(suffixWays.isEmpty()) {
                        ArrayList<String> temp = new ArrayList<>();
                        temp.add(val);
                        suffixWays.add(temp);
                        result.add(temp);
                    } else {
                        for (ArrayList<String> way : suffixWays) {
                            way.add(val);
                            result.add(way);
                        }
                    }
                }
            }
        }

        return result;

    }
}
