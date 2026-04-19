class Solution {
    boolean[] path;
    long[][][] dp;
    int [] num;
    
    public long countGoodIntegersOnPath(long l, long r, String directions) {
        path = new boolean[16];
        int row=0, col=0;
        path[0] = true;
        for(char c : directions.toCharArray()) {
            if(c == 'D') {
                row++;
            } else {
                col++;
            }
            path[row * 4 + col] = true;
        }
        long q = l;
        return count(r) - count(l-1);
    }
    long count(long N) {
        if(N<0) return 0;
        num = new int[16];
        String s = String.format("%016d", N);
        for(int i=0; i<16; i++) {
            num[i] = s.charAt(i) - '0';
        }
        dp = new long[16][2][11];
        for(long[][] a : dp) {
            for(long[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return solve(0,1,10);
    }
    long solve(int pos, int tight, int last) {
        if(pos == 16) return 1;
        if(dp[pos][tight][last] != -1) {
            return dp[pos][tight][last];
        }
        long ans =0;
        int lim = tight == 1 ? num[pos] : 9;
        for(int dig=0; dig<=lim; dig++) {
            int newTight = (tight == 1 && dig == lim) ? 1 : 0;
            if(path[pos]) {
                if(last != 10 && dig <last) continue;
                ans += solve(pos+1, newTight, dig);
            } else {
                ans += solve(pos+1, newTight, last);
            }
        }
        return dp[pos][tight][last] = ans;
    }
}