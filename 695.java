class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 1 && !vis[i][j]) {
                    maxArea = Math.max(maxArea, solve(grid, i, j, vis));
                }
            }
        }

        return maxArea;
    }

    public int solve(int[][] grid, int r, int c, boolean[][] vis) {

        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
           grid[r][c] == 0 || vis[r][c]) {
            return 0;
        }

        vis[r][c] = true;

        int area = 1;

        area += solve(grid, r + 1, c, vis);
        area += solve(grid, r - 1, c, vis);
        area += solve(grid, r, c + 1, vis);
        area += solve(grid, r, c - 1, vis);

        return area;
    }
}
