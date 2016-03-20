// Given a string, determine if a permutation of the string could form a palindrome.

// For example,
// "code" -> False, "aab" -> True, "carerac" -> True.

// Hint:

// Consider the palindromes of odd vs even length. What difference do you notice?
// Count the frequency of each character.
// If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s==null) return true;
        int[] chars = new int[256];
        
        for (char c:s.toCharArray()) {
            chars[c]++;
        }
        
        int count = 0;
        
        for (int n:chars) {
            if (n % 2 == 1) {
                count++;
                if (count == 2) return false;
            }
        }
        
        return true;
    }
}