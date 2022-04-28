package com.sample.algo;

public class MaxSum {

    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int b[] = {-2, -5, 6, -2, -3, 1, 5, -6};
        int max = maxSum(b);
        System.out.println(max);
    }

    private static int maxSum(int a[]) {
        int max = 0;
        if(a.length > 0) {
            max = a[0];
            int currMax = a[0];
            for(int i = 1; i < a.length; i++) {
                currMax = Math.max(a[i], currMax + a[i]);
//                currMax = currMax>0? currMax + a[i] : a[i];
                max = Math.max(max, currMax);
            }
        }
        return max;
    }
}
