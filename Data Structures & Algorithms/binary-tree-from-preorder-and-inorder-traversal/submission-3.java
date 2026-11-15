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

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] pre, int[] in) {
        int n = pre.length;
        for(int i=0; i<in.length; i++) {
            map.put(in[i], i);
        }
        return build(pre, 0, n-1, in, 0, n-1);
    }

    private TreeNode build(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;
        int rootVal = pre[preStart];
        int rootIndex = map.get(rootVal);

        int leftLen = rootIndex - inStart;
        int rightLen = inEnd - rootIndex;

        
        TreeNode root = new TreeNode(rootVal);
        root.left = build(pre, preStart + 1, preStart + leftLen, in, inStart, inStart + leftLen -1);

        root.right = build(pre, preStart + leftLen + 1, preEnd, in, rootIndex + 1, rootIndex + rightLen);

        return root;
    }











}
