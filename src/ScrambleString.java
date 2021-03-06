/*
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
import java.util.*;
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())  
            return false;  
        
        if(s1.length()==1 && s2.length()==1)
            return s1.charAt(0) == s2.charAt(0);  
    
       char[] t1 = s1.toCharArray(), t2 = s2.toCharArray();
       Arrays.sort(t1);
       Arrays.sort(t2);
       if(!new String(t1).equals(new String(t2)))
         return false;
         
       if(s1.equals(s2)) 
         return true;
         
       for(int split = 1; split < s1.length(); split++){
           String s11 = s1.substring(0, split);
           String s12 = s1.substring(split);
           
           String s21 = s2.substring(0, split);
           String s22 = s2.substring(split);
           if(isScramble(s11, s21) && isScramble(s12, s22))
             return true;
           
           s21 = s2.substring(0, s2.length() - split);
           s22 = s2.substring(s2.length() - split);
           if(isScramble(s11, s22) && isScramble(s12, s21))
            return true;
       }
       return false;
    }
}
