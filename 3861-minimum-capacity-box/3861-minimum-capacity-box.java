class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int minC = Integer.MAX_VALUE;
        int minI = -1;
        for(int i=0; i<capacity.length; i++) {
            if(capacity[i] >= itemSize && capacity[i] < minC) {
                minC = capacity[i];
                minI = i;
            }
        }
        return minI;
    }
}