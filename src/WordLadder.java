/*
 * Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation 
 * sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
import java.util.*;
public class WordLadder {
     
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        
        Queue<String> queue = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int len = beginWord.length();
        queue.offer(beginWord); 
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String key = queue.poll();
            int level = map.get(key) + 1;
            char arr[] = key.toCharArray();
            
            for (int i = 0; i < len; i++) {
                for (char c = 'a'; c <= 'z';c++) {
                    // same word, skip it 
                    if (c == key.charAt(i))
                        continue;
                    arr[i] = c;
                    String n = new String(arr);
                    // find the target and return the value
                    if (n.equals(endWord))
                        return level;
                    // already visited this node, skip it
                    if (map.containsKey(n))
                        continue;
                    // not in the dictionary, skip it 
                    if (!wordDict.contains(n))
                        continue;
                    
                    // put the new word into queue
                    queue.offer(n);
                    // record the level of new word
                    map.put(n, level);
                    
                }
                // get the original word
                arr[i] = key.charAt(i);
            }
            
            
        }
        
        return 0;
    }
}
