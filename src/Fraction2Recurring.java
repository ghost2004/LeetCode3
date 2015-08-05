/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".

 */
import java.util.*;

public class Fraction2Recurring {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";
        String result = "";
        
        // get the sign first
        if ((numerator < 0) ^ (denominator < 0)) {
            result += "-";
        }
        
        // turn the number into unsigned number
        // use long to avoid overflow
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        
        // quotient 
        long res = num/den;
        result += String.valueOf(res);
        
        // get the reminder first, if it is zero then we are done
        long reminder = (num % den) * 10;
        if (reminder == 0)
            return result;
        result += ".";
        // map for the reminder and index in the string
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        
        // keep running until reminder is zero
        while (reminder != 0 ){
            // check the reminder in the map
            Integer idx = map.get(reminder);
            if (idx != null) {
                // the reminder is showed up before, so here is the infinity loop
                // get the left part of infinity loop
                String left = result.substring(0, idx);
                // get the right part of infinity loop
                String right = result.substring(idx);
                result = left +"(" +right+")";
                return result;
            }
            
            // save the reminder and index into map
            map.put(reminder, result.length());
            // get current quotient
            res = reminder/den;
            result += String.valueOf(res);
            // get next reminder
            reminder = (reminder%den) * 10;
            
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        Fraction2Recurring f = new Fraction2Recurring();
        System.out.println(f.fractionToDecimal(1, 6));
        System.out.println(f.fractionToDecimal(-1, -2147483648));
    }
}
