/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcelSheetColTitle {
    public String convertToTitle(int n) {
        String out = "";
        if (n <= 0)
            return out;
        
        while (n > 0) {
            char t = (char)('A'+(--n) % 26);
            out = t+out;
            n /= 26;
        }
        
        return out;
    }
}
