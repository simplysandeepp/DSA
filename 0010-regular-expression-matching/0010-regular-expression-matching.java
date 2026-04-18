class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        Boolean[][] dp = new Boolean[m + 1][n + 1];
        return solve(0, 0, s, p, dp);
    }

    public boolean solve(int i, int j, String s, String p, Boolean[][] dp) {
        if (dp[i][j] != null) return dp[i][j];
        if (j == p.length()) {
            return dp[i][j] = (i == s.length());
        }

        boolean match = (i <s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j)== '.'));
        if (j+1 < p.length() && p.charAt(j+1) == '*') {
            return dp[i][j] = (solve(i, j + 2, s, p, dp) || (match && solve(i + 1, j, s, p, dp)));
        }
        //normal caes
        if (match) {
            return dp[i][j] = solve(i + 1, j + 1, s, p, dp);
        }
        return dp[i][j] = false;
    }
}