/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        helper(root);
        return sb.toString();
    }

    private void helper(TreeNode node) {
        if(node == null) {
            sb.append("N:");
            return;
        }
        sb.append(String.valueOf(node.val)).append(":");
        helper(node.left);
        helper(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(":");
        int[] ind = {0};
        return deserialize(vals, ind);
    }

    private TreeNode deserialize(String[] vals, int[] ind) {
        if(vals[ind[0]].equals("N")) {
            ind[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[ind[0]]));
        ind[0]++;
        root.left = deserialize(vals, ind);
        root.right = deserialize(vals, ind);
        return root;
    }
}
