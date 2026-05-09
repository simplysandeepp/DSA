class Solution {
    public int minFlips(String s) {
        String str = s;
        int n=s.length();
        int ones =0;
        char[] arr = str.toCharArray();
        for(char c: arr) {
            if(c == '1') {
                ones++;
            }
        }
        int c1 = ones;
        int c2 = n-ones;
        int c3 = Math.abs(ones-1);
        int ans = Math.min(c1, Math.min(c2, c3));
        if(n>=2) {
            int x = arr[0] == '1' ? 1 : 0;
            int y = arr[n-1] == '1' ? 1 : 0;
            int c4 = 2 + ones - 2*x - 2*y;
            ans = Math.min(ans,c4);
        }
        return ans;
    }
}