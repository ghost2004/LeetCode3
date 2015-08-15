/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 */

public class MulitplyStrings {
    public String multiply(String num1, String num2) {
        // reverse the string so that we can do math from last digit 
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        // the maximal length of output is sum of 2 input
        int d[] = new int[n1.length() + n2.length()];
        
        // multiply every digits from 2 inputs
        for (int i = n1.length() -1;  i >= 0; i--) {
            for (int j = n2.length()-1; j >= 0; j--) {
                d[i+j] += (n1.charAt(i) - '0') *(n2.charAt(j) - '0');
            }
        }
        
        // calculate every digit
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < d.length; i++) {
            int mod = d[i] % 10;
            int carry = d[i] /10;
            if (i < d.length-1) {
                d[i+1] += carry;
            }
            sb.insert(0, mod);
        }
        
        // remove the start '0's
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }

}
