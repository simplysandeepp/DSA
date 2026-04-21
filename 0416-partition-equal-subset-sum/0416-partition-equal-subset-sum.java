class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums){
            sum +=n; 
        }
        
        if (sum%2 != 0){
            return false;
        }

        int half = sum/2;
        boolean[] dp = new boolean[half+1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = half; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[half];
    }
}