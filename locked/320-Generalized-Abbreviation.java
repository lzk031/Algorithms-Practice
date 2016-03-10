// Write a function to generate the generalized abbreviations of a word.

// Example:
// Given word = "word", return the following list (order does not matter):
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
// Show Company Tags
// Show Tags
// Show Similar Problems


public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if (word==null) return res;
        rec(res, word, new StringBuilder());
        return res;
    }
    
    private void rec(List<String> res, String word, StringBuilder path) {
        int n = word.length();
        if (n==path.length()) {
            res.add(decode(word, path));
            return;
        }
        for (int i=0; i<2; i++) {
            path.append(i);
            rec(res, word, path);
            path.deleteCharAt(path.length()-1);
        }
    }
    
    private String decode(String word, StringBuilder path) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i=0; i<path.length(); i++) {
            char c = path.charAt(i);
            if (c=='0') { // not changed
                if (count>0) {
                    res.append(count);
                    count = 0;
                }
                res.append(word.charAt(i));
            } else {
                count++;
            }
        }
        if (count>0) res.append(count);
        return res.toString();
    }
}