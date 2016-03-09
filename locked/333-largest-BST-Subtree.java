/**
 *
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), 
 * where largest means subtree with largest number of nodes in it.
 *
 */

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
    public int largestBSTSubtree(TreeNode root) {
        return rec(root).maxTree;
        
    }
    
    private Wrapper rec(TreeNode root) {
        Wrapper w = new Wrapper();
        if (root==null) {
            w.isBST = true;
            return w;
        }
        
        Wrapper left = rec(root.left);
        Wrapper right = rec(root.right);
        if (!left.isBST || !right.isBST) {
            w.maxTree = Math.max(left.maxTree, right.maxTree);
            return w;
        }
        if (root.val<left.maxVal || root.val>right.minVal) {
            w.maxTree = Math.max(left.maxTree, right.maxTree);
            return w;
        }
        w.maxTree = left.maxTree + right.maxTree + 1;
        w.isBST = true;
        w.maxVal = Math.max(root.val, right.maxVal);
        w.minVal = Math.min(left.minVal, root.val);
        return w;
    }
    
    private class Wrapper {
        int maxVal;
        int minVal;
        int maxTree;
        boolean isBST;
        public Wrapper() {
            maxVal = Integer.MIN_VALUE;
            minVal = Integer.MAX_VALUE;
            maxTree = 0;
            isBST = false;
        }
    }
}