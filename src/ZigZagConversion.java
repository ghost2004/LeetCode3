/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of 
 * rows like this: (you may want to display this pattern in a fixed font for better
 *  legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 2)
            return s;
        // buffer for each rows
        String arr[] = new String[numRows];
        /* 
         * the loop should be 2*(n-1)
         * For example row = 3 , the loop is 0 1 2 1
         */
        int size = 2*(numRows-1);
        // the map from loop id to line number
        int map[] = new int[size];
         
        int step  = 1;
        // first character is always in line 0
        map[0] = 0;
        // create the map
        for (int i = 1; i < size; i++) {
            // keep increasing until reach the bottom line
            if (i == numRows) {
                // reach the bottom line and it needs to going up
                step = -1; 
            }
            map[i] = map[i-1] + step;
        }
        
        // initialize each lines
        for (int i = 0; i < numRows;i++) 
            arr[i] = new String("");
        
        // for each characters in this string 
        // find the line number by mapping
        for (int i = 0; i < s.length();i++) {
            arr[map[i % size]] += s.charAt(i);
        }
        
        // assemble the each rows into one string 
        String out = new String();
        for (int i = 0; i < numRows;i++) 
            out += arr[i];
        
        return out;
            
    }
}
