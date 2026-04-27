class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for (int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    int dfs(int[][] grid, int r, int c) {
        if (r<0 || c < 0 || r >= grid.length || c >=grid[0].length
                || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0; 
        return 1
                + dfs(grid,r+1,c)
                + dfs(grid,r-1,c)
                + dfs(grid,r,c+1)
                + dfs(grid,r,c-1);
    }
}
