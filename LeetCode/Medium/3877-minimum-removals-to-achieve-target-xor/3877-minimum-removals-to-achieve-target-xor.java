class Solution {
    public int minRemovals(int[] nums, int target) {
        int n=nums.length;
        int maxi=16384;
        int dp[] = new int[maxi];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int num : nums){
            int[] arr = Arrays.copyOf(dp, maxi);
            for(int i=0; i<maxi; i++) {
                if(dp[i]!= -1) {
                    int curr = i^num;
                    if(dp[i] + 1>arr[curr]) {
                        arr[curr] = dp[i]+1;
                    }
                }
            }
            dp=arr;
        }

        return dp[target]== -1 ? -1 : n-dp[target];
        
    }
}