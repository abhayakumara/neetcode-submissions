class Solution {
    class Node{
        Node[] links;
        boolean end;

        Node() {
            links = new Node[26];
            end = false;
        }
    }

    Set<String> ans = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Node root = build(words);
        int rows = board.length, cols = board[0].length;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                dfs(board, i, j, root, "");
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(char[][] board, int i, int j, Node node, String word) {
        int rows = board.length, cols = board[0].length;

        if(i < 0 || j < 0 || i>=rows || j >= cols || board[i][j] =='*' || node.links[board[i][j] - 'a'] == null) {
            return;
        }
        char ch = board[i][j];
        int index = ch -'a';

        //visited
        board[i][j] = '*';
        node = node.links[index];
        word+=ch;
        if(node.end) {
            ans.add(word);
        }
        dfs(board, i+1, j, node, word);
        dfs(board, i-1, j, node, word);
        dfs(board, i, j+1, node, word);
        dfs(board, i, j-1, node, word);
        board[i][j] = ch;
    }

    private Node build(String[] words) {
        Node root = new Node();

        for(String word : words) {
            Node temp = root;

            for(char ch : word.toCharArray()) {
                int index = ch - 'a';
                if(temp.links[index] == null) {
                    temp.links[index] = new Node();
                }
                temp = temp.links[index];
            }
            temp.end = true;
        }
        return root;
    }
}
