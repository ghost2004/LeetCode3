/*
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int out = 0;
        int len = s.length();
        int t = 1;
        for (int i = len-1; i >= 0 ;i--) {
            int v = (s.charAt(i)  - 'A' + 1)*t;
            out += v;
            t*=26;
        }
        
        return out;
    }

}
