// Given a binary tree, find the length of the longest consecutive sequence path.

// The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

// For example,
//    1
//     \
//      3
//     / \
//    2   4
//         \
//          5
// Longest consecutive sequence path is 3-4-5, so return 3.
//    2
//     \
//      3
//     / 
//    2    
//   / 
//  1
// Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

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
    public int longestConsecutive(TreeNode root) {
        return rec(root).maxLen;
    }
    
    private Result rec(TreeNode root) {
        Result res = new Result();
        if (root==null) return res;
        if (root.left==null && root.right==null) {
            res.maxLen = res.curLen = 1;
            return res;
        }
        Result left = rec(root.left);
        Result right = rec(root.right);
        res.curLen = 1;
        if (root.left!=null && root.val-root.left.val==-1) {
            res.curLen = Math.max(res.curLen, left.curLen+1);
        }
        if (root.right!=null && root.val-root.right.val==-1) {
            res.curLen = Math.max(res.curLen, right.curLen+1);
        }
        res.maxLen = Math.max(left.maxLen, right.maxLen);
        res.maxLen = Math.max(res.maxLen, res.curLen);
        return res;
    }
    
    private static class Result {
        int maxLen;
        int curLen;
        public Result() {
            maxLen = 0;
            curLen = 0;
        }
    }
}