/*
 * Given a string, determine if it is a palindrome, considering only
 *  alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good
 question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    private int findAlaphaNum(String t, int i, int dir) {
        while (i >= 0 && i < t.length()) {
            char c = t.charAt(i);
            if ((c >= 'a' && c <='z') ||(c >= '0' && c <='9'))
                return i;
            i+=dir;
        }
        return i;
    }
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) 
            return true;
        int len = s.length();
        String t = s.toLowerCase();
        int left = findAlaphaNum(t,0,1);
        int right = findAlaphaNum(t,len-1,-1);
        
        while (left < right) {
            if (t.charAt(left) != t.charAt(right))
                return false;
            left = findAlaphaNum(t,left+1,1);
            right = findAlaphaNum(t,right-1,-1);
        }
                   
        return true;
    }

}
