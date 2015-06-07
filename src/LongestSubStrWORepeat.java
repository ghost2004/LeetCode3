import java.util.Arrays;

/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubStrWORepeat {
    public int lengthOfLongestSubstring(String s) {
        int map[] = new int[256];
        int recLen = 0;
        if (s == null || s.length() == 0)
            return recLen;
        Arrays.fill(map, -1);
        
        int lastIdx = -1;
        int curLen = 0;
        int len = s.length();
        
        for (int i = 0; i < len;i++) {
            int key = (int)s.charAt(i);
            if (map[key] == -1 || map[key] < lastIdx) {
                curLen++;
            } else {
                lastIdx = map[key] + 1;
                recLen = Math.max(recLen,curLen);
                curLen = i - lastIdx + 1;
            }
            map[key] = i;
        }
        recLen = Math.max(recLen,curLen);
        return recLen;
    }
}
