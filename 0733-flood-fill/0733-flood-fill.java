class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int real = image[sr][sc];
        if (real == color) return image;
        dfs(image,sr,sc,real,color);
        return image;
    }

    void dfs(int[][] image, int r, int c, int real, int color) {
        // boundary check
        if (r<0 || c<0 || r >= image.length || c >= image[0].length)
            return;

        //different color check
        if (image[r][c] != real)
            return;
        image[r][c] = color;

        // all four directions
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int i = 0; i < 4; i++) {
            int x = r + dir[i][0];
            int y = c + dir[i][1];
            dfs(image, x, y, real, color);
        }
    }
}