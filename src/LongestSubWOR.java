/*
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating  letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubWOR {
    public int lengthOfLongestSubstring(String s) {
        if (s== null || s.length() == 0)
            return 0;
        int map[] = new int[256];
        int i;
        int len = s.length();
        for (i = 0; i < 256; i++)
            map[i] = -1;
        int max = 1;
        int lastIdx = 0;
        int length = 0;
        for (i = 0;i < len;i++) {
            char c = s.charAt(i);
            if (map[c] == -1 || map[c] < lastIdx) {
                length++;
            } else {
                max = Math.max(length, max);
                
                lastIdx = map[c] + 1;
                length = i - lastIdx +1;
            }
            map[c] = i;
        }
        max = Math.max(length, max);
        return max;
    }

}
