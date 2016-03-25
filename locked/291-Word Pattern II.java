// Given a pattern and a string str, find if str follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

// Examples:
// pattern = "abab", str = "redblueredblue" should return true.
// pattern = "aaaa", str = "asdasdasdasd" should return true.
// pattern = "aabb", str = "xyzabcxzyabc" should return false.
// Notes:
// You may assume both pattern and str contains only lowercase letters.

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        int[] patMap = new int[26];
        int[] len = new int[26];
        Map<String, Integer> strMap = new HashMap<String, Integer>();
        Arrays.fill(patMap, -1);
        Arrays.fill(len, 1);
        return search(patMap, strMap, pattern, str, 0, 0, len);
    }
    
    private boolean search(int[] patMap, Map<String, Integer> strMap, String pattern, String str, int pStart, int sStart, int[] len) {
        if (pStart == pattern.length()) {
            if (sStart == str.length())
                return true;
            else 
                return false;
        }
        int eend = str.length();
        for (int i=pattern.length()-1; i>pStart; i--) {
            eend -= len[pattern.charAt(i)-'a'];
        }
        for (int end=sStart+1; end<=eend; end++) {
            String tmp = str.substring(sStart, end);
            int sym1 = patMap[pattern.charAt(pStart) - 'a'];
            int sym2 = -1;
            if (strMap.get(tmp) != null) sym2 = strMap.get(tmp);
            if (sym1 != sym2) continue;
            if (sym1 == -1) {
                patMap[pattern.charAt(pStart) - 'a'] = pStart;
                strMap.put(tmp, pStart);
                len[pattern.charAt(pStart)-'a'] = end - sStart;
                if (search(patMap, strMap, pattern, str, pStart+1, end, len)) return true;
                strMap.remove(tmp);
                len[pattern.charAt(pStart)-'a'] = 1;
                patMap[pattern.charAt(pStart) - 'a'] = -1;
            } else {
                if (search(patMap, strMap, pattern, str, pStart+1, end, len)) return true;
            }
        }
        return false;
    }
}