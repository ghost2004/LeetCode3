/*
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */

/*
 * 
one's number        numbers with one                                                                     Section
1                   1                                                                                     [1, 9]

11                  10  11  12  13  14  15  16  17  18  19                                                [10, 19]

1                   21                                                                                   [20, 29]

1                   31                                                                                   [30, 39]

1                   41                                                                                   [40, 49]

1                   51                                                                                   [50, 59]

1                   61                                                                                   [60, 69]

1                   71                                                                                   [70, 79]

1                   81                                                                                   [80, 89]

1                   91                                                                                   [90, 99]

11                 100  101  102  103  104  105  106  107  108  109                                      [100, 109]

21                 110  111  112  113  114  115  116  117  118  119                                      [110, 119]

11                 120  121  122  123  124  125  126  127  128  129                                      [120, 129]

...                  ...                                                                                  ...
 */
public class NumberDigitOne {
    public int countDigitOne(int n) {

        int cnt = 0;
        int target = n;
        // scan the number from right to left
        for (long base = 1; base <= target; base *= 10) {
            // the number before current base -- left side
            long div = target/base;
            // current number
            long reminder = div % 10;
            if (reminder == 1) {
                // current number is 1
                // left side + right side + 1
                cnt += div/10*base+ target%base + 1;
            } else if (reminder == 0) {
                // current number is 0
                // left side
                cnt += div/10*base;
            } else {
                // current number >= 2
                // left side 
                cnt += (div/10+1)*base;
            }
        }
        
        return cnt;
    }

}
