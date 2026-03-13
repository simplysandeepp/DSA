import java.util.*;

class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0, right = (long)1e18;
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            if (canFinish(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    private boolean canFinish(long time, int height, int[] workerTimes) {
        long total = 0;
        
        for (int t : workerTimes) {
            long l = 0, r = height;
            
            while (l <= r) {
                long m = (l + r) / 2;
                long need = t * m * (m + 1) / 2;
                
                if (need <= time) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            
            total += r;
            if (total >= height) return true;
        }
        
        return total >= height;
    }
}