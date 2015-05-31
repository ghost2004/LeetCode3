/*
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while
 preserving the order of characters. No two characters may map to the same
  character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */
import java.util.HashMap;
import java.util.HashSet;
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashSet<Character> set = new HashSet<Character> ();
        int i;
        int length = s.length();
        
        for (i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
                continue;        
            } else if (set.contains(t.charAt(i)))
                return false; 
            map.put(s.charAt(i), t.charAt(i));
            set.add(t.charAt(i));
        }
        
        return true;
    }
    public boolean isIsomorphic2(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            System.out.println(s.charAt(i)+"  "+t.charAt(i));
            if (map.containsKey(s.charAt(i))){
                if (t.charAt(i)==map.get(s.charAt(i))) continue;
                else return false;
            }
            else if (map.containsValue(t.charAt(i))) return false;
            map.put(s.charAt(i),t.charAt(i));
        }
        return true;
    }

    public static void main(String args[]) {
        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println(is.isIsomorphic2("ab", "ca"));
    }
}
