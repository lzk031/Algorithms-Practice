//   Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
//
//   For example:
//   Given a binary tree {1,2,3,4,5},
//       1
//      / \
//     2   3
//    / \
//   4   5

// return the root of the binary tree [4,5,2,#,#,3,1].
//   4
//  / \
// 5   2
//    / \
//   3   1  

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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode parent = null;
        TreeNode sibling = null;
        TreeNode cur = root;
        while (cur!=null) {
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            cur.left = sibling;
            cur.right = parent;
            parent = cur;
            sibling = right;
            cur = left;
        }
        return parent;
    }
    
    
}