class Solution {
    int[][][] dp = new int[101][21][101];

    int solve(int[] houses, int[][] cost, int m, int n, int t, int i, int prv, int nbr){
        if(nbr > t) return Integer.MAX_VALUE;
        if(i == m){
            return t == nbr ? 0 : Integer.MAX_VALUE;
        }
        if(dp[i][prv][nbr] != -1) return dp[i][prv][nbr];

        int ans = Integer.MAX_VALUE;

        if
        (houses[i] != 0){
            int color = houses[i];
            return solve(houses, cost, m, n, t, i+1, color, (color != prv) ? nbr+1 : nbr);
        } else {
            for(int j = 1; j <= n; j++){
                int cur = solve(houses, cost, m, n, t, i+1, j, (prv != j) ? nbr+1 : nbr);
                if(cur == Integer.MAX_VALUE) continue;
                ans = Math.min(ans, cur + cost[i][j-1]);
            }
        }
        return dp[i][prv][nbr] = ans;
    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        for(int i=0;i<101;i++){
            for(int j=0;j<21;j++) {
                for(int k=0;k<101;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        int ans = solve(houses, cost, m, n, target, 0, 0, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}