// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Find all strobogrammatic numbers that are of length = n.

// For example,
// Given n = 2, return ["11","69","88","96"].

// Hint:

// Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
// Show Company Tags
// Show Tags
// Show Similar Problems

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        if (n<=0) return new ArrayList<String>();
        List<String> dp[] = (List<String>[]) new List[n];
        dp[0] = new ArrayList<String>();
        dp[0].add("1");
        dp[0].add("8");
        dp[0].add("0");
        if (n==1) return dp[0];
        dp[1] = new ArrayList<String>();
        dp[1].add("11");
        dp[1].add("88");
        dp[1].add("69");
        dp[1].add("96");
        if (n==2) return dp[1];
        dp[1].add("00");
        for (int i=2; i<n; i++) {
            dp[i] = new ArrayList<String>();
            List<String> inner = dp[i-2];
            for (String s:inner) {
                dp[i].add("1"+s+"1");
                dp[i].add("8"+s+"8");
                dp[i].add("6"+s+"9");
                dp[i].add("9"+s+"6");
                if (i<n-1) dp[i].add("0"+s+"0");
            }
        }
        
        return dp[n-1];
    }
}