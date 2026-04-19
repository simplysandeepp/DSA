// class Solution {
//     public int maxDistance(int[] n1, int[] n2) {
//         int n=n1.length, m=n2.length;
//         int max =0;
//         for(int i=0; i<n; i++) {
//             for(int j=i; j<m; j++){
//                 if(n1[i] <= n2[j]){
//                     int x = Math.abs(i - j);
//                     max = Math.max(max, x);
//                 }
//             }
//         }
//         return max;
//     }
// }


class Solution {
    public int maxDistance(int[] n1, int[] n2) {
        int i, j=1;
        for (i=0; i<n1.length && j<n2.length; j++)
            if (n1[i] > n2[j]) {
                i++;
            }
        return j-i-1;
    }
}