/*
 * Given a string s and a dictionary of words dict, add spaces in s to 
 * construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 */
import java.util.*;

public class WordBreakII {
    List<String> out;
    Set<String> dict;
    boolean flag[];
    public void dumpList(Vector<String> list) {
        String t = new String();
        for (int i = 0; i < list.size(); i++) {
            t += list.elementAt(i);
            if (i != list.size()-1)
                t +=" ";
        }
        out.add(t);
    }
    
    public void wordBreak(String s, int idx, Vector<String> list) {
        if (idx == s.length()) {
            dumpList(list);
            return;
        }
        int len = s.length();
        for (int i = idx+1; i <= len; i++) {
            String key = s.substring(idx, i);
            if (dict.contains(key) && flag[i]) {
                list.add(key);
                int before = out.size();
                wordBreak(s, i, list);
                if (out.size() == before) {
                    flag[i] = false;
                }
                list.remove(list.size()-1);
            }
        }
            
    }
    
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        out = new ArrayList<String>();
        dict = wordDict;
        if (wordDict == null || wordDict.isEmpty() || 
                s == null || s.length() == 0)
            return out;
        Vector<String> list = new Vector<String>();
        flag = new boolean[s.length()+1];
        Arrays.fill(flag, true);
        wordBreak(s, 0, list);
        return out;
        
    }
    
    public static void main(String args[]) {
        WordBreakII w = new WordBreakII();
        Set<String> d = new HashSet<String>();
        d.add("a");
        w.wordBreak("a", d);
    }

}
