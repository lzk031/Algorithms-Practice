// There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

// For example,
// Given the following words in dictionary,

// [
//   "wrt",
//   "wrf",
//   "er",
//   "ett",
//   "rftt"
// ]
// The correct order is: "wertf".

// Note:
// You may assume all letters are in lowercase.
// If the order is invalid, return an empty string.
// There may be multiple valid order of letters, return any one of them is fine.

public class Solution {
    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        boolean[] visited = new boolean[26];
        Set<Character>[] neighbors = (Set<Character>[]) new Set[26];
        Queue<Character> queue = new LinkedList<Character>();
        StringBuilder res = new StringBuilder();
        for (int i=0; i<26; i++) {
            neighbors[i] = new HashSet<Character>();
        }
        
        Set<Character> candidates = new HashSet<Character>();
        for (char c:words[0].toCharArray()) {
            candidates.add(c);
        }
        
        for (int i=1; i<words.length; i++) {
            String last = words[i-1];
            String cur = words[i];
            int first, second;
            first = second = 0;
            while (first < last.length() && second < cur.length()) {
                candidates.add(last.charAt(first));
                candidates.add(cur.charAt(second));
                if (last.charAt(first) != cur.charAt(second)) {
                    Set<Character> set = neighbors[last.charAt(first) - 'a'];
                    if (set.add(cur.charAt(second))) {
                        inDegree[cur.charAt(second) - 'a']++;
                    }
                    first++; second++; break;
                }
                first++; second++;
            }
            while (first < last.length()) {
                candidates.add(last.charAt(first++));
            }
            while (second < cur.length()) {
                candidates.add(cur.charAt(second++));
            }
        }
        
        int count = candidates.size();
        for (char c:candidates) {
            if (inDegree[c - 'a'] == 0) {
                queue.add(c);
                count--;
            }
        }
        
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            res.append(cur);
            for (char nei:neighbors[cur - 'a']) {
                inDegree[nei - 'a']--;
                if (inDegree[nei - 'a'] == 0) {
                    queue.add(nei);
                    count--;
                }
            }
        }
        if (count > 0) return "";
        return res.toString();
        
        
    }
}