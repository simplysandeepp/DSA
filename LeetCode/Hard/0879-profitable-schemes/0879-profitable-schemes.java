class Solution {
    int[][][] dp = new int[102][102][102];
    int mod = (int)1e9 + 7;

    public int solve(int k, int i, int j, int n, int minProfit, int[] group, int[] profit) {
            if (k == profit.length) {
            if (j >= minProfit && n >= i) return 1;
            return 0;
        }
        if (i > n) return 0;
        if (dp[k][i][j] != -1) return dp[k][i][j];
        int include = 0, notInclude = 0;
        notInclude = solve(k + 1, i, j, n, minProfit, group, profit);
        include = solve(k + 1,i + group[k],Math.min(j + profit[k], minProfit),n,minProfit,group, profit);
        return dp[k][i][j] = (include % mod + notInclude % mod) % mod;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                for (int k = 0; k < 102; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(0, 0, 0, n, minProfit, group, profit);
    }
}