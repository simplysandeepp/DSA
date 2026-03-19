class Solution {
    int[] tree;
    int size = 20002;
    public List<Integer> countSmaller(int[] nums) {
        tree = new int[size];
        Integer[] res = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int index = nums[i] + 10001;
            res[i] = query(index - 1);
            update(index);
        }
        return Arrays.asList(res);
    }
    private void update(int i) {
        while (i < size) {
            tree[i] += 1;
            i += i & (-i);
        }
    }
    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }
}