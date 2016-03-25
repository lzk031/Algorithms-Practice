// Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

// Note:
// Given target value is a floating point.
// You may assume k is always valid, that is: k ≤ total nodes.
// You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
// Follow up:
// Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

// Hint:

// Consider implement these two helper functions:
// getPredecessor(N), which returns the next smaller node to N.
// getSuccessor(N), which returns the next larger node to N.
// Try to assume that each node has a parent pointer, it makes the problem much easier.
// Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
// You would need two stacks to track the path in finding predecessor and successor node separately.

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        TreeNode larger = null;
        TreeNode smaller = null;
        TreeNode cur = root;
        Stack<TreeNode> sStack = new Stack<TreeNode>();
        Stack<TreeNode> lStack = new Stack<TreeNode>();
        
        while (cur != null) {
            sStack.add(cur);
            lStack.add(cur);
            if (target > (double) cur.val) {
                if (smaller == null || smaller.val < cur.val) smaller = cur;
                cur = cur.right;
            } else {
                if (larger == null || larger.val > cur.val) larger = cur;
                cur = cur.left;
            }
        }
        
        if (larger != null) {
            while (lStack.peek() != larger) lStack.pop();
        }
        
        if (smaller != null) {
            while (sStack.peek() != smaller) sStack.pop();
        }
        
        Integer left, right;
        left = right = null;
        List<Integer> res = new ArrayList<Integer>();
        while (k>0) {
            k--;
            if (larger == null) {
                res.add(smaller.val);
                smaller = getPrev(smaller, sStack);
            } else if (smaller == null) {
                res.add(larger.val);
                larger = getNext(larger, lStack);
            } else {
                double up = Math.abs((double)larger.val - target);
                double down = Math.abs((double)smaller.val - target);
                if (up < down) {
                    res.add(larger.val);
                    larger = getNext(larger, lStack);
                } else {
                    res.add(smaller.val);
                    smaller = getPrev(smaller, sStack);
                }
            }
        }
        return res;
    }
    
    private TreeNode getPrev(TreeNode cur, Stack<TreeNode> stack) {
        if (cur.left != null) {
            stack.push(cur.left);
            cur = cur.left;
            while (cur.right != null) {
                stack.push(cur.right);
                cur = cur.right;
            }
            return cur;
        } else {
            stack.pop();
            while (!stack.isEmpty()) {
                if (stack.peek().val < cur.val) return stack.peek();
                cur = stack.pop();
            }
            return null;
        }
    }
    
    private TreeNode getNext(TreeNode cur, Stack<TreeNode> stack) {
        if (cur.right != null) {
            stack.push(cur.right);
            cur = cur.right;
            while (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            }
            return cur;
        } else {
            stack.pop();
            while (!stack.isEmpty()) {
                if (stack.peek().val > cur.val) return stack.peek();
                cur = stack.pop();
            }
            return null;
        }
    }
}