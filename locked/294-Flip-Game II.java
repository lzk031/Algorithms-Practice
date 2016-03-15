// You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

// Write a function to determine if the starting player can guarantee a win.

// For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

// Follow up:
// Derive your algorithm's runtime complexity.

public class Solution {
    public boolean canWin(String s) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        return help(new StringBuilder(s), map);
    }
    
    private boolean help(StringBuilder s, Map<String, Boolean> map) {
        if (map.containsKey(s.toString())) return map.get(s.toString());
        boolean res = true;
        
        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i)==s.charAt(i+1) && s.charAt(i)=='+') {
                // found = true;
                s.setCharAt(i, '-');
                s.setCharAt(i+1, '-');
                res = res && help(s, map);
                s.setCharAt(i, '+');
                s.setCharAt(i+1, '+');
                if (!res) break;
            }
        }
        
        
        
        res = !res;
        map.put(s.toString(), res);
        return res;
        
    }
}