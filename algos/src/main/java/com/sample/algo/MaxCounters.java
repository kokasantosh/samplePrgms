package com.sample.algo;

public class MaxCounters {
    public static void main(String[] args) {
        int a[] = {3, 4, 4, 6, 1, 4, 4};
        int n = 5;
        int result[] = maxCounters(a, n);

        for(int i = 0; i < result.length; i ++) {
            System.out.println(result[i]);
        }
    }

    private static int[] maxCounters(int[] a, int n) {
        int[] result = new int[n];
        int max_counter = n + 1;
        int currentMax = 0;
        int latestFill = 0;
        for(int index = 0; index < a.length; index ++) {
            int currentVal = a[index];
            if(currentVal == max_counter){
                latestFill = currentMax;
            } else {
                if(result[currentVal - 1] < latestFill) {
                    result[currentVal - 1] = latestFill + 1;
                } else {
                    result[currentVal - 1]++;
                }

                currentMax = Math.max(currentMax, result[currentVal - 1]);
            }
        }

        for(int index = 0; index < n; index ++) {
            if(result[index] < latestFill) {
                result[index] = latestFill;
            }
        }
        return result;
    }
}
