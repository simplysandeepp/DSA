class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int cnt =0;
        char arr = String.valueOf(digit).charAt(0);
        for(int n : nums) {
            String s = Integer.toString(n);
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)==arr){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}