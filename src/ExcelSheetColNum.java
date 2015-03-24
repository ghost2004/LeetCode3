/*
 * Given a column title as appear in an Excel sheet, 
 * return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */
public class ExcelSheetColNum {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.toUpperCase();
        
        int val = 0;
        int base = 1;
        int idx = s.length() - 1;
        
        while (idx >= 0) {
            val += (s.charAt(idx) - 'A' +1)*base;
            
            base*=26;
            idx--;
        }
        
        return val;
        
    }
}
