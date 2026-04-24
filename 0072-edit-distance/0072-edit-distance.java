// class Solution {
//     public int minDistance(String word1, String word2) {
//         return solve(word1, word2, 0, 0);
//     }

//     int solve(String w1, String w2, int i, int j) {
        
//         if(i == w1.length()) return w2.length() - j;
//         if(j == w2.length()) return w1.length() - i;

//         // if characters match
//         if(w1.charAt(i) == w2.charAt(j)) {
//             return solve(w1, w2, i+1, j+1);
//         }

//         int delete = solve(w1, w2, i+1, j);
//         int insert = solve(w1, w2, i, j+1);
//         int replace = solve(w1, w2, i+1, j+1);

//         return 1 + Math.min(delete, Math.min(insert, replace));
//     }
// }



class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(word1, word2, 0, 0);
    }

    int solve(String w1, String w2, int i, int j) {

            // ye tere base cond hogye
        if(i == w1.length()) 
            return w2.length() - j;
        if(j == w2.length()) 
            return w1.length() - i;

        if(dp[i][j] != -1) 
            return dp[i][j];

            // match mil gya
        if(w1.charAt(i) == w2.charAt(j)) {
            return dp[i][j] = solve(w1, w2, i+1, j+1);
        }

        // tino opn
        int delete = solve(w1, w2, i+1, j);
        int insert = solve(w1, w2, i, j+1);
        int replace = solve(w1, w2, i+1, j+1);

// min return karde
        return dp[i][j] = 1 + Math.min(delete, Math.min(insert, replace));
    }
}