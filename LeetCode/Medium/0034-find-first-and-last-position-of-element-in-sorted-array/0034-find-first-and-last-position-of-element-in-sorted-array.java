class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        int l = helper(nums, target, true);
        int r = helper(nums, target, false);
        arr[0] = l;
        arr[1] = r;
        return arr;        
    }

    private int helper(int[] nums, int target, boolean search) {
        int l = 0;
        int r = nums.length - 1;
        int idx = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                idx = mid;
                if (search) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return idx;
    }

}