// Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

// Find the maximum coins you can collect by bursting the balloons wisely.

// Note: 
// (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
// (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

// Example:

// Given [3, 1, 5, 8]

// Return 167

//     nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        
        int res = rec(nums, 0, nums.length-1, dp);
        return res;
    }
    
    private int rec(int[] nums, int start, int end, int[][] dp) {
        if (start > end) return 0;
        if (dp[start][end] > 0) return dp[start][end];
        int res = 0;
        int first = start-1;
        int third = end+1;
        for (int second=start; second<=end; second++) {
            int tmp = 1;
            if (first >= 0) tmp *= nums[first];
            tmp *= nums[second];
            if (third < nums.length) tmp *= nums[third];
            tmp += rec(nums, first+1, second-1, dp) + rec(nums, second+1, third-1, dp);
            res = Math.max(res, tmp);
        }
        dp[start][end] = res;
        return res;
    }
}