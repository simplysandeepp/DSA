class Solution {
    private Integer[][][] dp;
    private int n;
    private int m;
    public int cherryPickup(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        dp=new Integer[n][m][m];
        int ans= solver(grid,0,0,m-1);
        return ans<0?0:ans;
    }
    private int solver(int[][] grid,int r,int c1,int c2){
        if(c1>=m || c2>=m || c1<0 || c2<0)return -(int)1e9;
        if(r==n-1){
            return (c1==c2)?grid[r][c1]:grid[r][c1]+grid[r][c2];
        }
        if(dp[r][c1][c2]!=null)return dp[r][c1][c2];

        int cherry=0;
        if(c1==c2){
            cherry=grid[r][c1];
        }
        else{
            cherry=grid[r][c2]+grid[r][c1];
        }
        int maxi=-(int)1e9;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                maxi=Math.max(maxi,solver(grid,r+1,c1+i,c2+j));
            }
        }

        return dp[r][c1][c2]=cherry+maxi;
    }
}