// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Write a function to determine if a number is strobogrammatic. The number is represented as a string.

// For example, the numbers "69", "88", and "818" are all strobogrammatic.

public class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> reversed = new HashMap<Character, Character>();
        reversed.put('0', '0');
        reversed.put('1', '1');
        reversed.put('6', '9');
        reversed.put('8', '8');
        reversed.put('9', '6');
        int n = num.length();
        for (int i=0; i<n/2+1; i++) {
            if (reversed.get(num.charAt(i))==null || reversed.get(num.charAt(i)) != num.charAt(n-i-1)) return false;
        }
        return true;
    }
}