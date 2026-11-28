class PrefixTree {
    class Node {
        Node[] links;
        boolean end;
        Node() {
            links = new Node[26];
            end = false;
        }
    }
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (temp.links[index] == null) {
                return false;
            }
            temp = temp.links[index];
        }
        return temp.end;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (temp.links[index] == null) {
                return false;
            }
            temp = temp.links[index];
        }
        return true;
    }
}
