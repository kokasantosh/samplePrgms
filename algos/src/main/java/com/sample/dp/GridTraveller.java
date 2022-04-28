package com.sample.dp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
    public static void main(String[] args) {
        Map<String, BigDecimal> mem = new HashMap<>();
        System.out.println("Number of ways we can travel: " + gridTravellerWays(18,18, mem));
        System.out.println("Number of ways we can travel: " + gridTravellerTabWays(3,3));
    }

    private static BigDecimal gridTravellerWays(int m, int n, Map<String, BigDecimal> mem) {
        if(m <= 0 || n <= 0) { return BigDecimal.ZERO; } if(m == 1 && n == 1) { return BigDecimal.ONE; }
        String key1 = Integer.valueOf(m).toString() + ", " + Integer.valueOf(n).toString();
        String key2 = Integer.valueOf(n).toString() + ", " + Integer.valueOf(m).toString();
        if(mem.containsKey(key1)) { return mem.get(key1);} else if(mem.containsKey(key2)) { return mem.get(key2);}
        mem.put(key1, gridTravellerWays(m - 1, n, mem).add(gridTravellerWays(m, n - 1, mem)));
        return mem.get(key1);
    }

    private static Integer gridTravellerTabWays(int m, int n) {
        int[][] table = new int[m+1][n+1];
        Arrays.stream(table).forEach(a -> Arrays.fill(a, 0));
        table[1][1] = 1;

        for(int i = 0; i <= m; i ++) {
            for(int j = 0; j <=n; j ++) {
                if(i + 1 <= m) {
                    table[i + 1][j] += table[i][j];
                }
                if(j + 1 <= n) {
                    table[i][j + 1] += table[i][j];
                }
            }
        }
        return table[m][n];
    }
}
