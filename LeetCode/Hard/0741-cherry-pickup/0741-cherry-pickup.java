class Solution {
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new Integer[n][n][n];
        return Math.max(0, helper(grid, 0, 0, 0, 0));
    }

    public int helper(int[][] grid , int r1, int c1, int r2, int c2 ){
        int n = grid.length;
        // Out of bounds cond.
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (dp[r1][c1][r2] != null) {
            return dp[r1][c1][r2];
        }
        //end me aggye
        if (r1 == n-1 && c1 == n-1) {
            return dp[r1][c1][r2] = grid[r1][c1];
        }
        // here we are collectuing all the cherries
        int cherry = Integer.MIN_VALUE;
        if (r1 == r2 && c1 == c2) {
            cherry = grid[r1][c1];
        } else {
            cherry = grid[r1][c1] + grid[r2][c2];
        }
        int rr = helper(grid,r1,c1+1,r2,c2+1); //rr
        int dd = helper(grid,r1+1,c1,r2+1,c2); //dd
        int rd = helper(grid,r1,c1+1,r2+1,c2); //rd
        int dr = helper(grid,r1+1,c1,r2,c2+1); //dr
        int ans = Math.max(Math.max(rr,dr),Math.max(dd,rd));
        return dp[r1][c1][r2] = cherry + ans;
    }
}