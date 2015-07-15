/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a 
 * space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */
import java.util.*;
public class WordBreak {
    // recursive  version
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        int len = s.length();
       
        if (wordDict.contains(s)) 
            return true;
        for (int i = 1; i < len-1;i++) {
            String left = s.substring(0,  i);
            String right = s.substring(i, len);
            if (wordBreak(left, wordDict) && wordBreak(right, wordDict))
                return true;
        }
        
        return false;
        
    }
    
    // DP solution
    public boolean wordBreakDP(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        if (wordDict == null || wordDict.isEmpty())
            return false;
        int len = s.length();
        // flag[i] means if the [0, i) substring is in dictionary
        boolean flag[] = new boolean[len+1];
        
        // initial state is always true
        flag[0] = true;
        
        for (int i = 1; i <= len; i++){
            // for substring [0, i)
            for (int j = 0; j < i; j++) {
                // for each different cut, j is the cut position
                flag[i] = flag[j] && wordDict.contains(s.substring(j, i));
                if (flag[i])
                    break;
            }
        }

        
        
        return flag[len];
    }
}
