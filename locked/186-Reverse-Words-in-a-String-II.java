// Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

// The input string does not contain leading or trailing spaces and the words are always separated by a single space.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Could you do it in-place without allocating extra space?

// Related problem: Rotate Array

public class Solution {
    public void reverseWords(char[] s) {
        if (s==null || s.length==1) return;
        int start = 0;
        for (int i=1; i<s.length; i++) {
            if (s[i]==' ') {
                reverseWord(s, start, i-1);
                start = i+1;
            }
        }
        reverseWord(s, start, s.length-1);
        reverseWord(s, 0, s.length-1);
    }
    
    private void reverseWord(char[] s, int start, int end) {
        while (start<end) {
            swap(s, start++, end--);
        }
    }
    
    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}