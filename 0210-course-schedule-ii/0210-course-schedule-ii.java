class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int x[] : prerequisites){
            int a = x[0];
            int b = x[1];

            adj.get(b).add(a);
        }
        Stack<Integer> st = new Stack<>();
        boolean[] Rvis = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                if(dfs(adj, vis, i, st, Rvis)) return new int[0];
            }
        }

        int[] ans = new int[st.size()];
        int idx = 0;
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }

        return ans;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr, Stack<Integer> st, boolean[] Rvis){
        vis[curr] = true;
        Rvis[curr] = true;
        for(int nbr : adj.get(curr)){
            if(!vis[nbr]){
                if(dfs(adj, vis, nbr, st, Rvis)) return true;
            }
            else if(Rvis[nbr]) return true;
        }

        Rvis[curr] = false;
        st.push(curr);

        return false;
    }
}