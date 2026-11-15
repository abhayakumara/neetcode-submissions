class Solution {
    public int numIslands(char[][] g) {
        //DFS
        int rows = g.length;
        int cols = g[0].length;

        int ans = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if((g[i][j] - '0') == 1) {
                    ans++;
                    dfs(g, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] g, int i, int j) {
        int rows = g.length;
        int cols = g[0].length;

        if(i >=0 && i< rows && j >=0 && j <cols && (g[i][j] - '0') == 1) {
            g[i][j] = 0;

            dfs(g, i+1, j);
            dfs(g, i-1, j);
            dfs(g, i, j+1);
            dfs(g, i, j-1);
        }
    }
}
