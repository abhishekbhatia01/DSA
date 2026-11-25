class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = (int)1e9;
        int price[] = new int[n];    
        Arrays.fill(price, INF);
        price[src] = 0;

        for(int i=0; i<=k; i++){
            int[] temp = price.clone();
            for(int[] e : flights){
                int u = e[0];
                int v = e[1];
                int p = e[2];

                if(price[u] != INF && price[u] + p < temp[v]){
                    temp[v] = price[u] + p;
                }
            }

            price = temp;
        }

        return price[dst] == INF ? -1 : price[dst];
    }
}