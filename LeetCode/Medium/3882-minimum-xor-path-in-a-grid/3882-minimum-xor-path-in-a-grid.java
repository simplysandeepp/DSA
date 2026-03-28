class Solution {
    public int minCost(int[][] g) {
        int m = g.length, n=g[0].length;
        boolean[][] prev = new boolean[n][1024];
        for(int i=0; i<m; i++) {
            boolean[][] curr = new boolean[n][1024];
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) {
                    curr[0][g[0][0]] = true;
                    continue;
                }
                for(int x=0; x<1024; x++) {
                    if((i>0 && prev[j][x]) || (j>0 && curr[j-1][x])) {
                        curr[j][x ^ g[i][j]] = true;
                    }
                }
            }
            prev = curr;
        }
        for(int x=0; x<1024; x++){
            if(prev[n-1][x]) return x;
        }
        return -1;
    }
}