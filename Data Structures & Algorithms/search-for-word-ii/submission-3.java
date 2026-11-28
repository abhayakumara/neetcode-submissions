
class Solution {

    class Node {
        Node[] links;
        boolean end;

        Node() {
            links = new Node[26];
            end = false;
        }
    }

    Set<String> ans = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {

        ans.clear();

        Node root = build(words);

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, "");
            }
        }

        return new ArrayList<>(ans);
    }

    private void dfs(char[][] board, int i, int j,
                     Node node, String word) {

        int rows = board.length;
        int cols = board[0].length;

        // Boundary and visited checks
        if (i < 0 || j < 0 || i >= rows || j >= cols
                || board[i][j] == '*') {
            return;
        }

        char ch = board[i][j];
        int index = ch - 'a';

        // Check whether the character exists in Trie
        if (node.links[index] == null) {
            return;
        }

        // Move to the next Trie node
        node = node.links[index];

        // Build current word
        word += ch;

        // Check if a complete word is found
        if (node.end) {
            ans.add(word);
        }

        // Mark cell as visited
        board[i][j] = '*';

        // Explore all four directions
        dfs(board, i + 1, j, node, word);
        dfs(board, i - 1, j, node, word);
        dfs(board, i, j + 1, node, word);
        dfs(board, i, j - 1, node, word);

        // Backtrack
        board[i][j] = ch;
    }

    private Node build(String[] words) {

        Node root = new Node();

        for (String word : words) {

            Node temp = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (temp.links[index] == null) {
                    temp.links[index] = new Node();
                }

                temp = temp.links[index];
            }

            temp.end = true;
        }

        return root;
    }
}
