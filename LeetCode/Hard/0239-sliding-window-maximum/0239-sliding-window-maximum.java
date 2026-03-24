class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = arr.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // window se bahar wala index hatao
            if (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.pollFirst();
            }
            // chote elements useless hai max ke liye
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]) {
                q.pollLast();
            }
            // current index push karo
            q.offerLast(i);
            // jab window size k ho jaye
            if (i >= k - 1) {
                res[idx++] = arr[q.peekFirst()]; // front pe max
            }
        }
        return res;
    }
}