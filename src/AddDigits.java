/*
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {
    
    public int addDigits(int num) {
        
        if (num == 0)
            return 0;
        
        int sum = 0;
        int t = num;
        while (t > 0) {
            sum += t%10;
            t = t/10;
        }
        if (sum %9 == 0)
            return 9;
        return sum%9;
                    
    }

}
