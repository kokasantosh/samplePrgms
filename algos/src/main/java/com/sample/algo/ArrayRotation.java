package com.sample.algo;

public class ArrayRotation {

    public static void main(String[] args) {
        int Array[] = {1, 2, 3, 4, 5};
        int N = Array.length;

        int K = 2;
        int output[] = RightRotate(Array, N, K);

        for(int i = 0; i < output.length; i ++) {
            System.out.println(output[i]);
        }

    }

    private static int[] RightRotate(int[] array, int n, int k) {
        int result[] = new int[n];

        for(int i = 0; i < n; i ++) {
            if(i < k) {
                result[i] = array[n + i - k];
            } else {
                result[i] = array[i - k];
            }
        }

        return result;
    }
}
