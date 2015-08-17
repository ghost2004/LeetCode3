/*
 * Example1: x = 123, return 321
Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {
        int sign = 1;
        long abs = x;
        long out = 0;
        if (x < 0) {
            sign = -1;
            abs = 0 - abs;
        }
        
        while (abs != 0) {
            out =  10*out + abs%10;
            abs /= 10;
        }
        
        if (out > Integer.MAX_VALUE)
            return 0;
        return (int)out*sign;
    }

}
