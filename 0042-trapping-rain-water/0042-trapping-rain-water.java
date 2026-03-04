class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int l = 0; //left
        int r = n - 1; //right
        int lm = 0; //left max
        int rm = 0; //righ max
        int ans = 0;
        while (l <= r) {
            if (lm <= rm) {
                lm = Math.max(lm, height[l]);
                ans += lm - height[l];
                l++;
            } else {
                rm = Math.max(rm, height[r]);
                ans += rm - height[r];
                r--;
            }
        }
        return ans;
    }
}