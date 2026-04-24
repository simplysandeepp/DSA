class Solution {
    int[][] dp;
    int temp;
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for (int num : nums) total += num;

        if (Math.abs(target) > total) return 0;
        temp = total;

        dp = new int[nums.length][2 * total + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, 0, 0, target);
    }

    int solve(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        if (dp[i][sum + temp] != -1) {
            return dp[i][sum + temp];
        }

        int add = solve(nums, i+1, sum+ nums[i],target);
        int sub = solve(nums, i+1, sum-nums[i], target);
        return dp[i][sum + temp] = add + sub;
    }
}