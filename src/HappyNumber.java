/*
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the
 number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
  Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 */
import java.util.*;

public class HappyNumber {
    public int[] getDigits(int n){
        String s = String.valueOf(n);
        int arr[] = new int[s.length()];
        int t = n;
        int idx = arr.length-1;
        while (t > 0) {
            arr[idx] = t%10;
            t = t/10;
            idx--;
        }
        return arr;
    }
    
    public boolean isHappy(int n) {
        int result = n;
        HashSet<Integer> set = new HashSet<Integer>();
        while (!set.contains(result)) {
            set.add(result);
            int arr[] = getDigits(result);
            result = 0;
            for (int i = 0; i < arr.length;i++)
                result += arr[i]*arr[i];
        }
        
        if (result == 1)
            return true;
        return false;
    }

}
