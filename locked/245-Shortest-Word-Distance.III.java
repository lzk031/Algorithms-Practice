// This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

// word1 and word2 may be the same and they represent two individual words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “makes”, word2 = “coding”, return 1.
// Given word1 = "makes", word2 = "makes", return 3.

// Note:
// You may assume word1 and word2 are both in the list.

// Show Company Tags
// Show Tags
// Show Similar Problems

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i;
        for (i=0; i<words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) break;
        }
        int res = Integer.MAX_VALUE;
        int cur = i;
        for (i=i+1; i<words.length; i++) {
            if (!isInPair(words[i], word1, word2)) continue;
            if (words[i].equals(words[cur])) {
                if (word1.equals(word2))
                    res = Math.min(res, i-cur);
            } else {
                res = Math.min(res, i-cur);
            }
            cur = i;
        }
        return res;
    }
    
    private boolean isInPair(String s, String word1, String word2) {
        return s.equals(word1) || s.equals(word2);
    }
}