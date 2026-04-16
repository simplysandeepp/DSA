import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int q : queries) {
            List<Integer> idxs = map.get(nums[q]);
            int sz = idxs.size();

            if (sz == 1) {
                res.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(idxs, q);
            int prev = idxs.get((pos + sz - 1) % sz);
            int next = idxs.get((pos + 1) % sz);

            int d1 = dist(q, prev, n);
            int d2 = dist(q, next, n);

            res.add(Math.min(d1, d2));
        }

        return res;
    }

    private int dist(int a, int b, int n) {
        int d = Math.abs(a - b);
        return Math.min(d, n - d);
    }
}