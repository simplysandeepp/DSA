class Solution {
    public int longestConsecutive(int[] nums) {
        int count = 1;   
        int n = nums.length;
        if(n == 0) return 0;

        Arrays.sort(nums);

        int max = 1;
        int j = 1;

        for(int i = 0; i < n - 1; i++){
            if(nums[j] == nums[i]) {
                j++; 
            }
            else if(nums[j] - nums[i] == 1){
                count++;
                j++;
            }
            else {
                max = Math.max(max, count);
                count = 1; 
                j++;
            }
        }

        return Math.max(max, count);
    }
}