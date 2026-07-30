class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length]; 
        solve(image, sr, sc, vis, color, image[sr][sc]);
        return image;
    }

    public void solve(int[][] image, int sr, int sc, boolean[][] vis, int color, int orgClr){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image.length || image[sr][sc] != orgClr || vis[sr][sc]){
            return;
        }

        vis[sr][sc] = true;
        image[sr][sc] = color;

        solve(image, sr+1, sc, vis, color, orgClr);
        solve(image, sr-1, sc, vis, color, orgClr);
        solve(image, sr, sc+1, vis, color, orgClr);
        solve(image, sr, sc-1, vis, color, orgClr);
    }
}
