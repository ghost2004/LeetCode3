/*
 * A message containing letters from A-Z is being encoded to numbers
 *  using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number
 of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */
public class DecodeWays {
    
    private int check(char o) {
        return (o == '0'?0:1);
    }
    
    private int check(char o, char t) {
        return (o == '1' || (o == '2') && t <='6' && t >='0')?1:0;
        
    }
            
    public int numDecodings(String s) {
        
        if (s == null || s.length() < 1 ||s.charAt(0) == '0') 
            return 0;
        
        int len = s.length();
        if (len == 1)
            return 1;
        int curCnt = 0;
        int preCnt = (check(s.charAt(0))*check(s.charAt(1))) + check(s.charAt(0), s.charAt(1));
        int preCnt2 = 1;
        
        for (int i = 2; i < len;i++) {
            if (check(s.charAt(i)) == 1) 
                curCnt += preCnt;
            if (check(s.charAt(i-1), s.charAt(i)) == 1) 
                curCnt += preCnt2;
            
            if (curCnt == 0)
                return 0;
            preCnt2 = preCnt;
            preCnt = curCnt;
            curCnt = 0;
        }
        
        return preCnt;
        
    }
    
    public static void main(String args[]) {
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings("110"));
    }
}
