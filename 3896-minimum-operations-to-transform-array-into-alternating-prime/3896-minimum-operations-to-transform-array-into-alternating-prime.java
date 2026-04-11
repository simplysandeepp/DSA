class Solution {
    public int minOperations(int[] nums) {
        int cnt=0;
        for(int i=0; i<nums.length; i++) {
            if(i%2==0) {
                while(!isPrime (nums[i])) {
                    nums[i]++; cnt++;
                }
            } else {
                while(isPrime(nums[i])) {
                    nums[i]++; cnt++;
                }
            }
        }
        return cnt;
    }
    public boolean isPrime(int n) {
        if(n<=1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0) return false;
        for(int j=2; j*j<=n; j++){
            if(n%j==0) return false;
        }
        return true;
    }    
}