/*
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ¡ú false
isMatch("aa","aa") ¡ú true
isMatch("aaa","aa") ¡ú false
isMatch("aa", "a*") ¡ú true
isMatch("aa", ".*") ¡ú true
isMatch("ab", ".*") ¡ú true
isMatch("aab", "c*a*b") ¡ú true
 */
public class RegExpMatching {
    public boolean isMatch(String s, String p) {
        // reach the end of the pattern
        // return true if s is also reach the end
        // otherwise return false
        if (p.length() == 0)
            return s.length() == 0;
        // only one character left in the pattern
        if (p.length() == 1) {
            // return true when 
            // 1. last character in s is same with in pattern
            // 2. last character in pattern is .
            if (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
                return true;
            else
                return false;
        }
        
        // so length of pattern is still bigger than 1
        if (p.charAt(1) == '*') {
            // the next character in pattern is *
            // skip current * and match the rest of pattern
            if (isMatch(s, p.substring(2)))
                return true;
            // match the first character and rest of it
            return s.length() > 0
                    && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))
                    && isMatch(s.substring(1), p);
            
        } else {
            // return true when
            // 1. current character same with pattern's
            // 2. . in pattern
            if ( s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    && isMatch(s.substring(1), p.substring(1)))
                return true;
            else 
                return false;
            
        }
        
        
    }
}
