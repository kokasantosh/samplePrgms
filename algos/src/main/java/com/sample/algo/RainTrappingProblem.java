package com.sample.algo;

public class RainTrappingProblem {

    public static void main(String[] args) {
        int[] input = {3, 0, 2, 0, 4};
        System.out.println("Amount of water store: " + getAmountOfWaterStored(input));
    }

    private static Integer getAmountOfWaterStored(int[] input) {
        int res = 0;
        int size = input.length;

        for(int i = 1; i < size - 1; i ++) {

            int leftMax = input[i];
            int rightMax = input[i];

            for(int j = 0; j < i; j++) {
                leftMax = Math.max(input[j], leftMax);
            }

            for(int j = i + 1; j < size; j++) {
                rightMax = Math.max(input[j], rightMax);
            }

            res += Math.min(leftMax, rightMax) - input[i];

        }

        return res;
    }


}
