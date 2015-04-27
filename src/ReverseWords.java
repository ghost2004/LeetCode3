/*
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
 */
public class ReverseWords {
    private void reverse(char in[], int start, int end) {
        if (start < 0 || end >= in.length)
            return;
        int left = start;
        int right = end;
        char tmp;
        while (left < right) {
           tmp = in[left];
           in[left] = in[right];
           in[right] = tmp;
           left++;
           right--;
        }
    }

    public String reverseWords(String s) {
        char buf[] = s.toCharArray();
        int length = buf.length;
        reverse(buf, 0, length);
        
        int idx = 0;
        int preIdx = 0;
        while (idx < length) {
            if (idx >= length || buf[idx] == ' ') {
                reverse(buf, preIdx, idx-1);
                preIdx = idx+1;
            }
                
            idx++;
            
        }
        
        return new String(buf);
    }

}
