package com.sample.dp;

public class KnapsackProblem {

    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(solveKnapsackProblem(W, wt, val, n));
    }

    private static int solveKnapsackProblem(int totalWeight, int[] weight, int[] value, int n) {
        if(totalWeight == 0 || n == 0) {
            return 0;
        }

        if(weight[n-1] > totalWeight) {
            return solveKnapsackProblem(totalWeight, weight, value, n-1);
        } else {
            return Math.max(value[n-1] + solveKnapsackProblem(totalWeight - weight[n-1], weight, value, n - 1),
                    solveKnapsackProblem(totalWeight, weight, value, n - 1)
            );
        }

    }

}
