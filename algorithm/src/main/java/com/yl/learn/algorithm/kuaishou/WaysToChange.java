package com.yl.learn.algorithm.kuaishou;

public class WaysToChange {

    public int waysToChange(int n) {
        return dfs(n, new int[n]);
    }

    private int dfs(int n, int[] cache) {
        if(n < 0) return 0;
        if(n < 5) return 1;
        if(cache[n] != 0) return cache[n];
        int sum = dfs(n - 1, cache) + dfs(n - 5, cache) + dfs(n - 10, cache) + dfs(n - 25, cache);
        cache[n] = sum % 1000000007;
        return sum;
    }

}
