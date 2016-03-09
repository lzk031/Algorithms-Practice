// Given an array of numbers, verify whether it is the correct 
// preorder traversal sequence of a binary search tree.

// You may assume each number in the sequence is unique.
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder==null || preorder.length==0) return true;
        Stack<Integer> stack = new Stack<Integer>();
        int min = Integer.MIN_VALUE;
        for (int n:preorder) {
            if (n<=min) return false;
            
            if (stack.isEmpty()) {
                stack.push(n);
                continue;
            }
            while (!stack.isEmpty() && stack.peek()<n) min = stack.pop();
            stack.push(n);
        }
        return true;
    }
}