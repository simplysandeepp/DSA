class Solution {
    public int waysToMakeFair(int[] nums) {
        int eve = 0, odd = 0;
        for (int i = 0; i < nums.length; i++)
            if ((i & 1) == 0) eve += nums[i];
            else odd += nums[i];
        int e = 0, o = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) eve -= nums[i];
            else odd -= nums[i];

            if (e + odd == o + eve)
                ans++;

            if ((i & 1) == 0) e += nums[i];
            else o += nums[i];
        }
        return ans;
    }
}