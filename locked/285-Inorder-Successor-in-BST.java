// Given a binary search tree and a node in it, find the in-order 
// successor of that node in the BST.

// Note: If the given node has no in-order successor in the tree, return null.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root==null) return null;
        TreeNode last = null;
        TreeNode cur = root;
        
        while (cur!=p) {
            if (cur.val<p.val) {
                cur = cur.right;
            } else {
                last = cur;
                cur = cur.left;
            }
        }
        
        if (cur.right!=null) {
            TreeNode tmp = cur.right;
            while (tmp.left!=null) tmp = tmp.left;
            return tmp;
        } else {
            return last;
        }
        
    }
}