package com.sample.algo;

public class ZaladoTask1 {
    public static void main(String[] args) {
        int[] a = {1,-2, 0, 5};
        int product = 1;
        for(int num: a) {
            if(num == 0) {
                product = 0;
                break;
            }
            if (num < 0) {
                product = -product;
            }
        }

        System.out.println(product);
    }
}
