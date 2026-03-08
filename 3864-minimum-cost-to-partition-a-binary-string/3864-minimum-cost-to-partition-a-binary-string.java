class Solution {
    public long minCost(String s, int encCost, int flatCost) {
        int n = s.length();
        int[] countOnes = new int[n];
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(i==0){
                countOnes[0] = ch=='1'? 1 : 0;
            }else{
                countOnes[i] = ch=='1'? countOnes[i-1]+1 : countOnes[i-1];
            }
        }
        return helper(0, n-1, encCost, flatCost, countOnes);
    }

    public long helper(int l, int r, int encCost, int flatCost, int[] countOnes){
        int n = r-l+1;
        int oneCount = l==0? countOnes[r] : countOnes[r]-countOnes[l-1];

        long noSplit = -1;
        if(oneCount==0){
            noSplit = flatCost;
        }else{
            noSplit = (long)n*oneCount*encCost;
        }

        long split = Long.MAX_VALUE;
        if(n % 2 == 0){
            int mid = (l+r)/2;
            split = helper(l, mid, encCost, flatCost, countOnes) 
            + helper(mid+1, r, encCost, flatCost, countOnes);
        }

        return Math.min(noSplit, split);
    }
}