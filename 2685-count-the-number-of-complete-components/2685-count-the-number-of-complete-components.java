class Solution {
    boolean[] vis;
    ArrayList<ArrayList<Integer>> g;

    public int countCompleteComponents(int n, int[][] edges) {
        vis = new boolean[n];
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int[] res = dfs(i);
                int nodes = res[0];
                int edgesCount = res[1] / 2; 
                if (edgesCount == nodes * (nodes-1)/2) {
                    count++;
                }
            }
        }

        return count;
    }

    public int[] dfs(int node) {
        vis[node] = true;
        int nodes = 1;
        int edges = g.get(node).size();
        for (int neigh : g.get(node)) {
            if (!vis[neigh]) {
                int[] res = dfs(neigh);
                nodes += res[0];
                edges += res[1];
            }
        }
        return new int[]{nodes, edges};
    }
}