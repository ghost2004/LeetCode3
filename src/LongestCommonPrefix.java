/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String out = "";
        if (strs == null || strs.length == 0)
            return null;
        
        if (strs.length == 1)
            return strs[0];
        boolean search = true;
        int idx = 0;
        while (search) {
            if (strs[0].length() <= idx)
                break;
            char key = strs[0].charAt(idx) ;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= idx || strs[i].charAt(idx) != key) {
                    search = false;
                    break;
                }
            }
            idx++;
            
            if (search)
                out += key;
                
        }
        
        
        
        return out;
        
    }
}
