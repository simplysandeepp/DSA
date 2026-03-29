class Solution {
    int[] parent, rank, d;
    int find(int x) {
        if(parent[x] != x) {
            int root = find(parent[x]);
            d[x] ^= d[parent[x]];
            parent[x] = root;
        }
        return parent[x];
    }
    public int numberOfEdgesAdded(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        d = new int[n];
        for(int i=0; i<n; i++) {
            parent[i]=i;
        }
        int count=0;
        for(int []e : edges) {
            int u = e[0], v=e[1], w=e[2];
            int ru=find(u), rv=find(v);

            if(ru==rv){
                if((d[u] ^ d[v]) == w) count++;
            } else {
                count++;
                int x = d[u] ^ d[v] ^ w;
                if(rank[ru] < rank[rv]) {
                    parent[ru] = rv;
                    d[ru] =x;
                } else if(rank[ru] > rank[rv]) {
                    parent[rv] = ru;
                    d[rv] = x;
                } else {
                    parent[rv] = ru;
                    d[rv] = x;
                    rank[ru]++;
                }
            }
        }
        return count;
    }
}