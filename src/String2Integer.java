/*
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, 
please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
You are responsible to gather all the input requirements up front.
 */
public class String2Integer {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int len = str.length();
        double out = 0;
        int sign = 1;
        
        int idx = 0;
        // find the first non-space character
        while (idx < len && str.charAt(idx) == ' ')
            idx++;
        if (idx == len)
            return 0;
        // read the sign
        if (str.charAt(idx) == '-') {
            sign = -1;
            idx++;
        } else if (str.charAt(idx) == '+') {
            idx++;
        }


        while (idx < len &&str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
            
            out = out*10 + str.charAt(idx) - '0';

            idx++;
        }
        
        if (out > Integer.MAX_VALUE) {
            if (sign == 1)
                return Integer.MAX_VALUE;
            else 
                return Integer.MIN_VALUE;
        }
        
        return (int)out*sign;
    }
    
    public static void main(String args[]) {
        String2Integer s = new String2Integer();
        System.out.println(s.myAtoi("     +004500"));
    }
}
