/*
 * Given a string s, partition s such that every substring of the
 * partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
import java.util.*;
public class PalindromePartitioning {
    
    private boolean isPalindrome(String s) {
        
        if (s.length() <= 1)
            return true;
        int left = 0;
        int right = s.length()-1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
    
    public void findNextPalindrome(ArrayList<ArrayList<String>> result, ArrayList<String> set, String s) {
        
        if (s.length() == 0) {
            result.add(new ArrayList<String>( set));
            return;
        }
        for (int i = 1; i<= s.length(); i++) {
            String n = s.substring(0, i);
            if (isPalindrome(n)) {
                set.add(n);
                findNextPalindrome(result, set, s.substring(i));
                set.remove(set.size()-1);
            }
        }
        
    }
    
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> out = new ArrayList<ArrayList<String>>();
        
        if (s == null || s.length() == 0)
            return out;
        
        
        ArrayList<String> list = new ArrayList<String>();
        findNextPalindrome(out, list, s);
        return out;
        
    }

}
