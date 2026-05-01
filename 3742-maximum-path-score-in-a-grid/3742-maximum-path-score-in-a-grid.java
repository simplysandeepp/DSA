class Solution {
    int m, n;
    public int maxPathScore(int[][] grid, int k) {
        //dp on grid
        m=grid.length; 
        n= grid[0].length;
        int[][][] dp = new int[m][n][k+1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int result = solve(0,0,0,grid,k,dp);    
        return result == Integer.MIN_VALUE ? -1 : result;
    }
    // public int solve(int i, int j, int cost, int[][] grid, int k,int[][][]dp) {
    //     m=grid.length; n= grid[0].length;
    //     if(i>=m || j>= n) {
    //         return Integer.MIN_VALUE;
    //     }
    //     int newCost = cost + ((grid[i][j] > 0) ? 1 : 0);        
    //     if(newCost > k) {
    //         return Integer.MIN_VALUE;
    //     }
    //     if(dp[i][j][cost] != -1) {
    //         return dp[i][j][cost];
    //     }
    //     if(i==m-1 && j==n-1) {
    //         return grid[i][j];
    //     }
    //     int r, d; //right and down
    //     r = solve(i,j+1,newCost,grid,k,dp);
    //     d = solve(i+1,j,newCost, grid,k,dp);
    //     if(r == Integer.MIN_VALUE && d == Integer.MIN_VALUE){
    //         return Integer.MIN_VALUE;
    //     }
    //     int best = Math.max(r,d) + grid[i][j];
    //     if(best == Integer.MIN_VALUE) {
    //         return dp[i][j][cost] = Integer.MIN_VALUE;
    //     }
    //     return dp[i][j][cost] = best;
    // }
        public int solve(int i, int j, int cost, int[][] grid, int k, int[][][] dp) {
        if(i >= m || j >= n) {
            return Integer.MIN_VALUE;
        }

        int newCost = cost + ((grid[i][j] > 0) ? 1 : 0);        
        if(newCost > k) {
            return Integer.MIN_VALUE;
        }

        if(dp[i][j][newCost] != -1) {
            return dp[i][j][newCost];
        }

        if(i == m - 1 && j == n - 1) {
            return dp[i][j][newCost] = grid[i][j];
        }

        int r = solve(i, j + 1, newCost, grid, k, dp);
        int d = solve(i + 1, j, newCost, grid, k, dp);

        if(r == Integer.MIN_VALUE && d == Integer.MIN_VALUE) {
            return dp[i][j][newCost] = Integer.MIN_VALUE;
        }

        int best = Math.max(r, d) + grid[i][j];
        return dp[i][j][newCost] = best;
    }   
}   