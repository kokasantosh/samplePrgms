package com.sample.javalatestfeatures;

import java.util.*;
import java.util.stream.Collectors;

public class StreamSample {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 10; i ++) {
            list.add(i);
        }
        Map<Integer, String> finalList = new HashMap<> ();
        list.forEach(a -> finalList.put(a, "abc"));
        System.out.println(finalList);
        System.out.println(list.parallelStream().map(StreamSample::doSomething).collect(Collectors.toList()));
        int sum = list.stream().filter(i -> i > 5).mapToInt(i -> i).sum();

        System.out.println(sum);

        System.out.println(list);

        list.removeIf(i -> i==2);

        System.out.println(list);
    }

    private static Map<Integer, String> doSomething(Integer num) {
        Map<Integer, String> result = new HashMap<>();
        result.put(num, "abc");
        return result;
    }

}
