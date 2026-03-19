import java.util.*;

class Solution {
    static class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int n) {
            this.n = n;
            this.tree = new int[4 * n];
        }

        public int query(int node, int L, int R, int ql, int qr) {
            if (L > qr || R < ql) return 0;
            if (ql <= L && R <= qr) return tree[node];

            int mid = L + (R - L) / 2;
            int left = query(2 * node + 1, L, mid, ql, qr);
            int right = query(2 * node + 2, mid + 1, R, ql, qr);
            return left + right;
        }

        public void update(int node, int L, int R, int idx) {
            if (L == R) {
                tree[node]++;
                return;
            }
            int mid = L + (R - L) / 2;
            if (idx <= mid) update(2 * node + 1, L, mid, idx);
            else update(2 * node + 2, mid + 1, R, idx);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long sum = 0;
        long[] pref = new long[n + 1];
        TreeSet<Long> set = new TreeSet<>();
        set.add(0L);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            pref[i + 1] = sum;
            set.add(sum);
            set.add(sum - (long)lower);
            set.add(sum - (long)upper);
        }

        HashMap<Long, Integer> hm = new HashMap<>();
        int idx = 0;
        for (Long val : set) hm.put(val, idx++);

        SegmentTree seg = new SegmentTree(idx);
        int result = 0;

        seg.update(0, 0, idx - 1, hm.get(0L));

        for (int i = 1; i <= n; i++) {
            int leftBound = hm.get(pref[i] - upper);
            int rightBound = hm.get(pref[i] - lower);

            result += seg.query(0, 0, idx - 1, leftBound, rightBound);
            seg.update(0, 0, idx - 1, hm.get(pref[i]));
        }
        return result;
    }
}