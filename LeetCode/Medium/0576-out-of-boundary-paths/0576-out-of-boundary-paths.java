import java.util.Arrays;

class Solution {
    int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp = new long[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return (int) solve(m, n, maxMove, startRow, startColumn, dp);
    }

    public long solve(int m, int n, int move, int r, int c, long[][][] dp) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 1;
        }
        if (move == 0) return 0;
        if (dp[r][c][move] != -1) {
            return dp[r][c][move];
        }
        long down = solve(m, n, move - 1, r + 1, c, dp);
        long up = solve(m, n, move - 1, r - 1, c, dp);
        long right = solve(m, n, move - 1, r, c + 1, dp);
        long left = solve(m, n, move - 1, r, c - 1, dp);
        long count = (down + up + right + left) % MOD;
        return dp[r][c][move] = count;
    }
}