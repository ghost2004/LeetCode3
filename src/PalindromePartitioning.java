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
    // the function to check if the string is palindrome or not
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
        // reach the end of the string, means found another solution, add the solution into 
        if (s.length() == 0) {
            result.add(new ArrayList<String>( set));
            return;
        }
        // scan the string from left to right
        for (int i = 1; i<= s.length(); i++) {
            // get current substring
            String n = s.substring(0, i);
            if (isPalindrome(n)) {
                // add the substring to the current solution set 
                set.add(n);
                // check the rest of the string
                findNextPalindrome(result, set, s.substring(i));
                // remove it from current solution set, looking for the next
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
