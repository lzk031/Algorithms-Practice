// Given a pattern and a string str, find if str follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

// Examples:
// pattern = "abba", str = "dog cat cat dog" should return true.
// pattern = "abba", str = "dog cat cat fish" should return false.
// pattern = "aaaa", str = "dog cat cat dog" should return false.
// pattern = "abba", str = "dog dog dog dog" should return false.
// Notes:
// You may assume pattern con

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        return encode1(pattern).equals(encode2(str));
    }
    
    private String encode1(String pattern) {
        int seq = 1;
        StringBuilder res = new StringBuilder();
        int[] map = new int[26];
        for (char c:pattern.toCharArray()) {
            if (map[c-'a'] == 0) {
                map[c-'a'] = seq;
                seq++;
            }
            res.append(map[c-'a']);
        }
        return res.toString();
    }
    
    private String encode2(String str) {
        int seq = 1;
        StringBuilder res = new StringBuilder();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word:str.split(" ")) {
            if (map.get(word) == null) {
                map.put(word, seq++);
            }
            res.append(map.get(word));
        }
        return res.toString();
    }
}