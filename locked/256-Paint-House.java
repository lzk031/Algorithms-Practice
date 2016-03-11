// There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

// The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

// Note:
// All costs are positive integers.

public class Solution {
    public int minCost(int[][] costs) {
        if (costs==null) return 0;
        int n = costs.length;
        int[][] dp = new int[n+1][3];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<3; j++) {
                dp[i+1][j] = Math.min(dp[i][(j+1)%3], dp[i][(j+2)%3]) + costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i=0; i<3; i++) {
            res = Math.min(res, dp[n][i]);
        }
        return res;
    }
}