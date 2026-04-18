class Solution {
    public double findMedianSortedArrays(int[] n1, int[] n2) {

        int m = n1.length; 
        int n = n2.length;
        int[] arr = new int[m + n];

        System.arraycopy(n1, 0, arr, 0, m);
        System.arraycopy(n2, 0, arr, m, n); 

        Arrays.sort(arr);
        int x = arr.length;

        if (x % 2 != 0) {
            return arr[x/2]; 
        } else {
            return (arr[x/2 - 1] + arr[x/2]) / 2.0;
        }
    }
}