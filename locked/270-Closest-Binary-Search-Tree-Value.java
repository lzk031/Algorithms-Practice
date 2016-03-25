Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.

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
    public int closestValue(TreeNode root, double target) {
        int larger = Integer.MAX_VALUE;
        int smaller = Integer.MIN_VALUE;
        boolean hasLarge = false;
        boolean hasSmall = false;
        TreeNode cur = root;
        while (cur != null) {
            double tmp = (double) cur.val;
            if (target < tmp) {
                hasLarge = true;
                larger = Math.min(larger, cur.val);
                cur = cur.left;
            } else {
                hasSmall = true;
                smaller = Math.max(smaller, cur.val);
                cur = cur.right;
            }
        }
        if (!hasSmall) return larger;
        if (!hasLarge) return smaller;
        double up = Math.abs(((double) larger) - target);
        double down = Math.abs(target - ((double) smaller));
        if (up > down) {
            return smaller;
        } else {
            return larger;
        }
        
    }
}