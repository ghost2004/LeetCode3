/*
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        int x = n;
        while (x != 1) {
            if ( (x&1) != 0)
                return false;
            x = x >>1;
        }
        return true;
    }
}
