/*
 * Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 */
import java.util.*;
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> out = new ArrayList<String>();
        if (strs == null || strs.length == 0)
            return out;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String key = null;
        
        for (int i = 0 ; i < strs.length; i ++) {
            char buf[] = strs[i].toCharArray();
            Arrays.sort(buf);
            key = new String(buf);
            Integer f = map.get(key);
            if (f == null) {
                map.put(key, i);
            } else {
                if (f != -1) {
                    out.add(strs[f]);
                    map.put(key, -1);
                }
                out.add(strs[i]);
            }
            
        }

        
        return out;
    }
}
