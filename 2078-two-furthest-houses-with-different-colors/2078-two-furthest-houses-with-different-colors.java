class Solution {
    public int maxDistance(int[] nums) {
        int n = nums.length;
        int l=0, r=0;
        for(int i=0; i<n; i++) {
            if(nums[i] != nums[n-1]) {
                l = i;
                break;
            }
        }
        for(int i=n-1; i>=0; i--) {
            if(nums[i] != nums[0]) {
                r = i;
                break;
            }
        }
        return Math.max(n-1-l, r);
    }
}