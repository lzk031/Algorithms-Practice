// This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

// Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “coding”, word2 = “practice”, return 3.
// Given word1 = "makes", word2 = "coding", return 1.

// Note:
// You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

// Show Company Tags
// Show Tags
// Show Similar Problems


public class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<Integer>());
            }
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int p1, p2;
        p1 = p2 = 0;
        while (p1<l1.size() && p2<l2.size()) {
            if (l1.get(p1)<l2.get(p2)) {
                while (p1<l1.size() && l1.get(p1)<l2.get(p2)) p1++;
                res = Math.min(res, l2.get(p2)-l1.get(p1-1));
            } else {
                while (p2<l2.size() && l1.get(p1)>l2.get(p2)) p2++;
                res = Math.min(res, l1.get(p1)-l2.get(p2-1));
            }
        }
        return res;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");