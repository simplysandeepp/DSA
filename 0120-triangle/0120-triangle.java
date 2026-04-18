// class Solution {
//     int n;
//     public int minimumTotal(List<List<Integer>> triangle) {
//         n = triangle.size();
//         return solveRec(0,0,triangle);
//     }
//     public int solveRec(int i, int j, List<List<Integer>> triangle) {
//         if(i == n-1) 
//             return triangle.get(i).get(j);

//         int down = triangle.get(i).get(j) + solveRec(i+1, j, triangle);
//         int diagonal = triangle.get(i).get(j) + solveRec(i+1, j+1, triangle);
//         return Math.min(down, diagonal);
//     }
// }


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];

        for(int i=0; i<n; i++) {
            dp[n-1][i]=triangle.get(n-1).get(i);
        }

        for(int i=n-2; i>=0; i--) {
            for(int j=i; j>=0; j--) {
                int down=triangle.get(i).get(j)+dp[i+1][j];
                int downRight=triangle.get(i).get(j)+dp[i+1][j+1];

                dp[i][j]=Math.min(down,downRight);
            }
        }

        return dp[0][0];
        
    }
}
