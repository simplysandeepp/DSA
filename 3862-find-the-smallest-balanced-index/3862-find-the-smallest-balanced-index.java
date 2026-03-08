class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n=nums.length;
        long[] rightP = new long[n];
        rightP[n-1] =1;
        for(int i=n-2; i>=0; i--) {
            rightP[i] = rightP[i+1] * nums[i+1];
            if(rightP[i] > 1e15) {
                rightP[i] = (long) 1e15;
            }
        }
        long leftSum = 0;

        for(int i=0; i<n; i++) {
            if(leftSum == rightP[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}