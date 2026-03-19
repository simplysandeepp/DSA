class Solution {

    static class SegTree {
        int n;
        int[]tree;
        public SegTree(int n) {
            this.n = n;
            tree = new int[4*n];
        }
        public int query(int node, int L, int R, int ql, int qr) {
            // no overlapping
            if(L > qr || R < ql) {
                return 0;
            }
            // fully overlapping
            if(ql <= L && R <= qr) {
                return tree[node];
            }
            // partial
            int mid = (L+R)/2 ;

            return query(2*node+1, L, mid, ql, qr) + query(2*node+2, mid+1, R, ql, qr);
        }

        public void update (int node, int L, int R, int idx) {
            if(L == R) {
                tree[node]++;
                return;
            }
            int mid = (L+R)/2;
            if(idx <= mid) {
                update(2*node+1, L, mid, idx);
            } 
            else {
                update(2*node+2, mid+1, R, idx);
            }
            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;

        for(int val : sorted) {
            if(!map.containsKey(val)) {
                map.put(val,idx++);
            }
        }

        //yaha hum segment tree la logic likhenge

        SegTree seg = new SegTree(idx);
        Integer [] ans = new Integer[n];

        //right ->left
        for(int i=n-1; i>=0; i--) {
            int val = map.get(nums[i]);
            ans[i] = seg.query(0, 0, idx-1, 0, val-1);  // ndoe, L, R, ql, qr
            seg.update(0, 0, idx-1, val);
        }
        return Arrays.asList(ans);
    }
}