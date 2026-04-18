class Solution {
    public int mirrorDistance(int n) {
        int m = rev(n);
        return Math.abs(n - m);
    }
    public int rev(int n) {
        int r=0;
        while(n != 0) {
            int d = n % 10;
            r = r * 10 + d;
            n /= 10;
        }
        return r;
    }
}
