class Solution {
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, n - 1, atlantic, heights);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific, heights);
            dfs(m - 1, j, atlantic, heights);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c, boolean[][] vis, int[][] h) {
        vis[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                !vis[nr][nc] &&
                h[nr][nc] >= h[r][c]) {

                dfs(nr, nc, vis, h);
            }
        }
    }
}