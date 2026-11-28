class WordDictionary {
    class Node{
        Node[] links;
        boolean end;

        Node() {
            links = new Node[26];
            end = false;
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
       return dfs(root, word, 0);
    }

    private boolean dfs(Node root, String word, int index) {
        if(index == word.length()) return root.end;

        char ch = word.charAt(index);

        if(ch == '.') {
            for(Node child : root.links) {
                if(child != null && dfs(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        }

        int pos = ch - 'a';
        if(root.links[pos] == null) {
            return false;
        }
        return dfs(root.links[pos], word, index + 1);
    }
}
