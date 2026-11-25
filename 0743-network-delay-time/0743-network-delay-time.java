class Solution {
    public class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : times){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new int[]{v,w});
        }

        boolean[] vis = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k, 0));

        while(!pq.isEmpty()){
            Pair x = pq.remove();
            int node = x.n;
            if(!vis[node]){
                vis[node] = true;
                for(int[] e : adj.get(node)){
                    int v = e[0];
                    int w = e[1];

                    if(dist[node]+w < dist[v]){
                        dist[v] = dist[node] + w;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
            
        }

        int max = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        
        return max;
    }
}