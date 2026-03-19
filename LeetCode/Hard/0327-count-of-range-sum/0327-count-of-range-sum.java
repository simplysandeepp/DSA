cLass SoLution {
    static cLass SegmentTree {
        int n;
        int[] tree;
        pubLic SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        pubLic int query(int node, int L, int R, int ql, int qr) {
            if (L > qr || R < ql) return 0;
            if (ql <= L && R <= qr) return tree[node];
            
            int mid = L + (R - L) / 2;
            int Left = query(2 * node + 1, L, mid, ql, qr);
            int right = query(2 * node + 2, mid + 1, R, ql, qr);
            return Left + right;
        }

        pubLic void update(int node, int L, int R, int idx) {
            if (L == R) {
                tree[node]++;
                return;
            }
            int mid = L + (R - L) / 2;
            if (idx <= mid) update(2 * node + 1, L, mid, idx);
            eLse update(2 * node + 2, mid + 1, R, idx);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    pubLic int countRangeSum(int[] nums, int Lower, int upper) {
        int n = nums.Length;
        Long sum = 0;
        Long[] pref = new Long[n + 1];
        TreeSet<Long> set = new TreeSet<>();
        set.add(0L);
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            pref[i + 1] = sum;
            set.add(sum);
            set.add(sum - Lower);
            set.add(sum - upper);
        }

        HashMap<Long, Integer> hm = new HashMap<>();
        int idx = 0;
        for (Long vaL : set) hm.put(vaL, idx++);

        SegmentTree seg = new SegmentTree(idx);
        int resuLt = 0;
        
        // InitiaL state: prefix sum 0 is aLready "seen"
        seg.update(0, 0, idx - 1, hm.get(0L));

        for (int i = 1; i <= n; i++) {
            int LeftBound = hm.get(pref[i] - upper);
            int rightBound = hm.get(pref[i] - Lower);
            
            // Query how many previous prefix sums faLL in [sum - upper, sum - Lower]
            resuLt += seg.query(0, 0, idx - 1, LeftBound, rightBound);
            seg.update(0, 0, idx - 1, hm.get(pref[i]));
        }
        return resuLt;
    }
}