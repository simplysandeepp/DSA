class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int m = grid.length, n = grid[0].length;
        int[] nums = new int[m * n];
        int i = 0;
        for (int[] row : grid) {
            for (int j : row) {
                nums[i++] = j;
            }
        }
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int count = 0;
        for (int j : nums) {
            int temp = Math.abs(j - mid);
            if( temp%x !=0) return -1;
            count += temp/x;
        }
        return count;
    }
}