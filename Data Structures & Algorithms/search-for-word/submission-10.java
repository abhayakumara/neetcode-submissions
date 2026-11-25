class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                int index = 0;
                if(dfs(i, j, board, word, visited, index)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, boolean[][] visited, int index) {
        int rows = board.length;
        int cols = board[0].length;
        if(index == word.length()) return true;

        if(i < 0 || j < 0 || i >=rows || j >= cols || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean found = dfs(i+1, j, board, word,visited, index + 1) || 
        dfs(i, j+1, board, word,visited, index + 1) ||
        dfs(i-1, j, board, word,visited, index + 1) ||
        dfs(i, j - 1, board, word,visited, index + 1);
        visited[i][j] = false;

        return found;

    }
}
