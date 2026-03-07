class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s;
        int ans = n;
        int miss = 0;

        for(int i = 0; i < 2*n; i++){
            char expected = (i % 2 == 0) ? '0' : '1';
            if(t.charAt(i) != expected) miss++;
            if(i >= n){
                int left = i - n;
                char expLeft = (left % 2 == 0) ? '0' : '1';
                if(t.charAt(left) != expLeft) miss--;
            }
            if(i >= n - 1){
                int mis1 = n - miss;
                ans = Math.min(ans, Math.min(miss, mis1));
            }
        }
        return ans;
    }
}