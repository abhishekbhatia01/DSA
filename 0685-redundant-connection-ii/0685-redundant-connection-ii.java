class Solution {

    int[] parent;

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;
        int[] parentNode = new int[n + 1];

        int[] first = null;
        int[] second = null;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (parentNode[v] == 0) {
                parentNode[v] = u;
            } else {
                first = new int[]{parentNode[v], v};
                second = edge;
                break;
            }
        }

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            if (edge == second)
                continue;

            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) {
                if (first != null)
                    return first;

                return edge;
            }

            parent[rootV] = rootU;
        }

        return second;
    }

    int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }
}