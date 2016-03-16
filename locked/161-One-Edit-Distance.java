// Given two strings S and T, determine if they are both one edit distance apart.

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (Math.abs(n-m)>1) return false;
        if (n>m) {
            return isOneDelete(t, s);
        } else if (n<m) {
            return isOneDelete(s, t);
        } else {
            int notMatch = 0;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i)!=t.charAt(i)) notMatch++;
            }
            return notMatch == 1;
        }
    }
    
    private boolean isOneDelete(String s, String t) { // s is shorter than t
        int i=0;
        for (i=0; i<s.length(); i++) {
            if(s.charAt(i)!=t.charAt(i)) break;
        }
        if (i==s.length()) return true;
        for (; i<s.length(); i++) {
            if (s.charAt(i)!=t.charAt(i+1)) return false;
        }
        return true;
    }
}