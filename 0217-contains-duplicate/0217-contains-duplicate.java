// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         int j = 1;
//         for(int i=0; i<nums.length-1; i++){
//             if(nums[i] == nums[j]){
//                 return true;
//             } else {
//                 j++;
//             }
//         } return false;
//     }
// }

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int num : nums){
            // duplicate found 
            if(s.contains(num)) return true; 
            s.add(num);
        }
        return false;
    }
}