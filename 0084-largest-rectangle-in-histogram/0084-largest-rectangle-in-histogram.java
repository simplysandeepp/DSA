// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         int maxi = 0;

//         for (int i = 0; i < n; i++) {
//             int h=heights[i];

//             int l = i;
//             while (l>=0 && heights[l] >= h) {
//                 l--;
//             }
//             int r = i;
//             while (r<n && heights[r] >= h) {
//                 r++;
//             }
//             int width = r-l-1;
//             maxi = Math.max(maxi, h * width);
//         }

//         return maxi;
//     }
// }

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxi = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!s.isEmpty() && h < heights[s.peek()]) {
                int height = heights[s.pop()];
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                maxi = Math.max(maxi, height * width);
            }
            s.push(i);
        }
        return maxi;
    }
}