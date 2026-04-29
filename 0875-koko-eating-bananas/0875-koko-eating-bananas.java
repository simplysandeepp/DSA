class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        int ans = high;
        while (l <= high) {
            int mid = l + (high - l) / 2;

            if (isPossible(mid, h, piles)) {
                ans = mid;        
                high = mid - 1;   
            } else {
                l = mid + 1;    
            }
        }

        return ans;
    }

    public boolean isPossible(int mid, int h, int[] arr) {
        long totalHours = 0;

        for (int i = 0; i < arr.length; i++) {
            totalHours += (arr[i] + mid - 1) / mid; 
        }

        return totalHours <= h;
    }
}