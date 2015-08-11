import java.util.Arrays;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null & t == null)
            return true;
        if (s == null || t == null)
            return false;
        
        if (s.length() != t.length())
            return false;
        
        char left[] = s.toCharArray();
        char right[] = t.toCharArray();
        
        Arrays.sort(left);
        Arrays.sort(right);
        
        for (int i = 0; i < left.length;i++) {
            if (left[i] != right[i])
                return false;
        }
        return true;
    }
}
