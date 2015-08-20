/*
 * Given a string S, you are allowed to convert it to a palindrome by 
 * adding characters in front of it. Find and return the shortest 
 * palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        
        // build up the reverse string from s
        // take "eeca" as an example, reverse is "acee"
        String reverse = new StringBuilder(s).reverse().toString();
        
        // check the 0 to len-1,
        // we don't need to check the last one because that's the worst case
        for (int i = 0; i < s.length()-1; i++) {
            // check the reverse string in s
            // start with whole reverse first, when move to the right
            // take "eeca" as an example, reverse is "acee"
            // first check "acee" in the start of "eeca"
            // then check "cee" in start of "eeca"
            // then "ee" in start of "eeca", we will find it hits!
            
            if (s.startsWith(reverse.substring(i))) {
                /* it hits means we don't need to duplicate rest of characters in reverse
                   in this case "ee" is the start of "eeca", and we can use it
                   we just need to put reverse prefix in the palindrome
                
                 * 0 --> i --> where it hits the start with "eeca"
                 * |     |
                 * V     V
                 * a  c  e  e
                 * 
                 * so the output should be  "aceeca"
                 * 
                 */
                return reverse.substring(0, i)+s;
            }
        }
        
        // the worst case is no duplicate character in the string
        // keep the first character and double all others
        // for "abcd" is "dcbabcd"
        return reverse+s.substring(1);
    }
}
