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
    int[] ans = {0, 0};
    public int kthSmallest(TreeNode root, int k) {
        find(root, k, ans);
        return ans[1];
    }

    private void find(TreeNode node, int k, int[] ans) {
        if(node == null) return;
        find(node.left, k, ans);
        ans[0]++;
        if(ans[0] == k) {
            ans[1] = node.val;
            return;
        }
        find(node.right, k, ans);
    }
}
