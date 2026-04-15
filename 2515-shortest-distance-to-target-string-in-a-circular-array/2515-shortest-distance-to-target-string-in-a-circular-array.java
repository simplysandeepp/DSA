class Solution {
    public int closestTarget(String[] words, String target, int start) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int ch = (i - start + n) % n;
                int antich = (start - i + n) % n;
                ans = Math.min(ans, Math.min(ch, antich));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}