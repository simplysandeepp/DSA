/* The functions which builds the segment tree */
class GfG {
    static int st[];

    public static int[] constructST(int arr[], int n) {
        st = new int[4 * n];
        build(0, 0, n - 1, arr);
        return st;
    }

    public static void build(int idx, int l, int r, int[] arr) {
        if (l == r) {
            st[idx] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;

        build(2 * idx + 1, l, mid, arr);
        build(2 * idx + 2, mid + 1, r, arr);

        st[idx] = Math.min(st[2 * idx + 1], st[2 * idx + 2]);
    }

    public static int RMQ(int st[], int n, int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    public static int query(int idx, int L, int R, int qs, int qe) {
        if (R < qs || L > qe)
            return Integer.MAX_VALUE;
            
        if (qs <= L && R <= qe)
            return st[idx];

        int mid = L + (R - L) / 2;

        int left = query(2 * idx + 1, L, mid, qs, qe);
        int right = query(2 * idx + 2, mid + 1, R, qs, qe);

        return Math.min(left, right);
    }
}