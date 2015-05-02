import java.util.Arrays;

/*
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int s[] = Arrays.copyOf(digits, digits.length);
        int carry = 1;
        int idx = s.length - 1;
        do {
            s[idx] += carry;
            if (s[idx] >= 10) {
                carry = 1;
                s[idx] = 0;
            } else {
                carry = 0;
            }
            idx--;
        } while (idx >= 0 && carry == 1);
        
        if (carry == 0)
            return s;
        
        int s2[] = new int[s.length+1];
        s2[0] = 1;
        for (idx = 1; idx <= s.length;idx++)
            s2[idx] = s[idx-1]; 
        
        return s2;

    }

}
