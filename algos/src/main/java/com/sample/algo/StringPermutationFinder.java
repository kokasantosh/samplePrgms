package com.sample.algo;

public class StringPermutationFinder {

    public static void main(String[] args) {
        String str = "ABC";

        permutate(str, 0, str.length() - 1);
    }

    private static void permutate(String str, int l, int r) {
        if(l == r) {
            System.out.println(str);
        } else {
            for(int i = l; i <= r ; i ++) {
                str = swap(str, l, i);
                permutate(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
