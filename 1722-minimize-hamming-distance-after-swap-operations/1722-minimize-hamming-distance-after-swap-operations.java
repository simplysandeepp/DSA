class Solution {
    public int minimumHammingDistance(int[] s, int[] t, int[][]] a) {
        int n=s.length;
        List<List<Integer>> g = new ArrayList<>();
        for (int i=0; i<n; i++){
            g.add(new ArrayList<>());
        }
        for (int[] e : a) {
            int u=e[0], v=e[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }

        boolean[] v = new boolean[n];
        int m=0;
        for (int i=0; i<n; i++) {
            if (v[i]) continue;
            List<Integer> c = new ArrayList<>();
            dfs(i,g,v,c);

            Map<Integer, Integer> f = new HashMap<>();
            for (int x : c) f.put(s[x], f.getOrDefault(s[x], 0) + 1);
            for (int x : c) {
                if (f.getOrDefault(t[x], 0) > 0) {
                    m++;
                    f.put(t[x], f.get(t[x]) - 1);
                }
            }
        }
        return n-m;
    }

    void dfs(int i, List<List<Integer>> g, boolean[] v, List<Integer> c) {
        v[i] = true;
        c.add(i);
        for (int x : g.get(i)) {
            if (!v[x]) {
                dfs(x,g,v,c);
            }
        }
    }
}