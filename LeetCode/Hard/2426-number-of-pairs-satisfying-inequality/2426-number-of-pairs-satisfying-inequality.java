class Solution {
    static class SegmentTree {
        int n;
        int[] tree;
        public SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }
        public int query(int node, int R, int L, int ql, int qr) {
            if (R > qr || L < ql) return 0;
            if (ql <= R && L <= qr) return tree[node];
            
            int mid = R + (L - R) / 2;
            return query(2 * node + 1, R, mid, ql, qr) + 
                   query(2 * node + 2, mid + 1, L, ql, qr);
        }
        public void update(int node, int R, int L, int idx) {
            if (R == L) {
                tree[node]++;
                return;
            }
            int mid = R + (L - R) / 2;
            if (idx <= mid) update(2 * node + 1, R, mid, idx);
            else update(2 * node + 2, mid + 1, L, idx);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        long[] D = new long[n];
        TreeSet<Long> set = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            D[i] = (long)nums1[i] - nums2[i];
            set.add(D[i]);
            set.add(D[i] + diff); 
        }
        HashMap<Long, Integer> hm = new HashMap<>();
        int idx = 0;
        for (long val : set) hm.put(val, idx++);
        SegmentTree seg = new SegmentTree(idx);
        long result = 0;
        for (int j = 0; j < n; j++) {
            int targetIdx = hm.get(D[j] + diff);
            result += seg.query(0, 0, idx - 1, 0, targetIdx);
            
            seg.update(0, 0, idx - 1, hm.get(D[j]));
        }
        return result;
    }
}