/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinWinSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length())
            return "";
        String result ="";
        // map for characters in target
        int target[] = new int[256];
        // map for characters showed up
        int showup[] = new int[256];
        
        // build the map for target characters
        for (int i = 0; i < t.length();i++) {
            target[t.charAt(i)]++;
        }
        // minimal length found so far, set to length of S+1 so that every possible length in S is less than it
        int minLength = s.length()+1;
        // the left index of the window
        int winLeft = 0;
        // the number of characters that already showed up in the scan
        int matched = 0;
        
        // scan S from left to right
        for (int i =0; i < s.length();i++) {

            // current character is in the target map
            if (target[s.charAt(i)] != 0) {
                // if we are still expecting this character, increase the matched number in the map
                if (showup[s.charAt(i)] < target[s.charAt(i)] ) {
                    matched++;
                }
                showup[s.charAt(i)]++;
            }
            
            // all characters in target are showed up
            if (matched == t.length()) {
                // slide the window to left as much as possible
                // there are 2 possibilities
                // 1. the character at left window is not in the target
                // 2. the number of character at left window is more than we expected
                while (target[s.charAt(winLeft)] == 0 || target[s.charAt(winLeft)] < showup[s.charAt(winLeft)]) {
                    if (target[s.charAt(winLeft)] < showup[s.charAt(winLeft)])
                        showup[s.charAt(winLeft)]--;
                    winLeft++;
                }
                
                // check if we get a new minimal window length
                if (i - winLeft + 1 < minLength) {
                    minLength = i - winLeft + 1;
                    result = s.substring(winLeft, i+1);
                }
            }
            
            
        }
        
        return result;
    }
}
