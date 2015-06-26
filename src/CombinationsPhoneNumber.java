/*
 * iven a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
import java.util.*;
public class CombinationsPhoneNumber {
    String trans[] = {"", " ", "abc", "def", "ghi", "jkl",  
    "mno", "pqrs", "tuv", "wxyz"};
    
    private void dfs(String digits, int idx, String buf, ArrayList<String> set) {
        if (idx == digits.length()) {
            set.add(new String(buf));
            return;
        }
        int key = digits.charAt(idx) - '0';
        String candidate = trans[key];
        
        for (int i = 0; i < candidate.length(); i++) {
            String nbuf = buf + candidate.charAt(i);
            dfs(digits, idx+1, nbuf, set);
            
        }
        
    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String> out = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return out;
        dfs(digits, 0, "", out);
        return out;
        
    }

}
