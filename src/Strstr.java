/*
 * Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Strstr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return 0;
        if (needle.length() == 0) 
            return 0;
        int len = haystack.length() - needle.length();
        int n_len = needle.length();
        for (int i =0 ; i <= len;i++ ) {
            boolean flag = true;
            for (int j = 0; j <n_len; j++) {
                if (haystack.charAt(j+i) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag)
                return i;
        }
        return -1;
    }
}
