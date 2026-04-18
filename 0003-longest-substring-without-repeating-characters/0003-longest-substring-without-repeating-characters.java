class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        int[] arr = new int[128];

        Arrays.fill(arr, -1);
        int j =0;
        for(int i=0; i<n; i++) {
            if(arr[s.charAt(i)] >= j) {
                j = arr[s.charAt(i)] + 1;
            }
            arr[s.charAt(i)] = i;
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
