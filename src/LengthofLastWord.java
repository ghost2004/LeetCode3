/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 *  return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int length = 0;
        int idx = s.length()-1;
        
        while (idx >= 0 && s.charAt(idx) == ' ')
            idx--;
        
        if (idx == 0)
            return 1;
        else if (idx > 0) {
            while (idx >= 0 && s.charAt(idx) != ' ') {
                idx --;
                length++;
            }
        }
            
        return length;
        
    }
}
