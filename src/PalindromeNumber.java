/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int a = x;
        int y = 0;
        while (a >= 10) {
            y = 10*y + a %10;
            a /= 10;
        }
        y = 10*y+a;
        return (x==y);
    }

}
