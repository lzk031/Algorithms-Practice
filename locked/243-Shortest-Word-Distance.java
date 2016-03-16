// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “coding”, word2 = “practice”, return 3.
// Given word1 = "makes", word2 = "coding", return 1.

// Note:
// You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

// Show Company Tags
// Show Tags
// Show Similar Problems


public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i;
        for (i=0; i<words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) break;
        }
        int res = Integer.MAX_VALUE;
        int cur = i;
        for (i=i+1; i<words.length; i++) {
            if (!isInPair(words[i], word1, word2)) continue;
            if (words[i].equals(words[cur])) {
                cur = i;
            } else {
                res = Math.min(res, i-cur);
                cur = i;
            }
        }
        return res;
    }
    
    private boolean isInPair(String s, String word1, String word2) {
        return s.equals(word1) || s.equals(word2);
    }
}