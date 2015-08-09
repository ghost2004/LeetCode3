/*
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ¡ú false
isMatch("aa","aa") ¡ú true
isMatch("aaa","aa") ¡ú false
isMatch("aa", "*") ¡ú true
isMatch("aa", "a*") ¡ú true
isMatch("ab", "?*") ¡ú true
isMatch("aab", "c*a*b") ¡ú false
 */
public class WildcastMatching {
    public boolean isMatch(String s, String p) {
        if (p == null)
            return true;
        if (s == null)
            return false;
        // pointer of current string
        int sIdx = 0;
        // pointer of current pattern
        int pIdx = 0;
        // length of string and pattern
        int sLen = s.length();
        int pLen = p.length();
        
        // index of last * in pattern
        int starIdx = -1;
        // index of last mismatched pattern in string
        int misMatchIdx = -1;
        
        // scan the string from left to right
        while (sIdx < sLen) {
            if (pIdx < pLen && (p.charAt(pIdx) == '?' ||  p.charAt(pIdx) == s.charAt(sIdx))) {
                // two cases here:
                // case 1: character at each string matches
                // case 2: ? in pattern
                // move the index in string and pattern
                pIdx++;
                sIdx++;
            } else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                // meet the * in pattern
                // save the position of it
                starIdx = pIdx;
                // mismatched index of s could be start here
                misMatchIdx = sIdx;
                // move the index of pattern
                pIdx++;
            } else if (starIdx != -1) {
                // mismatched here
                // move index of pattern to next of the last star
                pIdx = starIdx+1;
                // move the index of string to next mismatched 
                sIdx = ++misMatchIdx;

            } else 
                return false;

        }
        
        // scan rest of pattern and see if it is all * there
        while (pIdx < pLen && p.charAt(pIdx) == '*')
            pIdx++;
        
        return pIdx == pLen;
    }
}
