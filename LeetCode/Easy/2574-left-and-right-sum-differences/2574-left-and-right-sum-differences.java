class Solution {
    public int[] leftRightDifference(int[] nums) {
        // answer[i] = prefix[i] - suffix[i]

        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] ans = new int[n];

        for(int i=1; i<n; i++) { //prefix sum
            l[i] = l[i-1] + nums[i-1];
        }
        for(int i=n-2; i>=0; i--) { // suffex sum
            r[i] = r[i+1] + nums[i+1];
        }
        for(int i=0;i<n;i++){ //stroing diff
            ans[i] =Math.abs(l[i]-r[i]);
        }
        return ans;
    }
}