/*
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class AddBinary {
    
    public int getInt(String a, int idx) {
        if (idx < 0)
            return 0;
        return a.charAt(idx)=='1' ? 1:0;
    }
    public String addBinary(String a, String b) {
        if (b == null || b.length() == 0)
            return a;
        if (a == null || a.length() == 0)
            return b;
        String out="";
        
        int idx_a = a.length()-1;
        int idx_b = b.length() - 1;
        
        int max = Math.max(idx_a, idx_b);
        
        int carry = 0;
        int sum;
        
        for (int i = 0 ; i <= max;i++) {
            sum = getInt(a,idx_a) + getInt(b, idx_b) + carry;
            carry = sum / 2;
            if (sum % 2 == 1)
                out = "1" + out;
            else
                out = "0" + out;
            idx_a--;
            idx_b--;
        }
        
        if (carry == 1)
            out = "1" + out;
        
        return out;
        
    }
    
    public static void main(String args[]) {
        AddBinary a = new AddBinary();
        
        System.out.println(a.addBinary("0", "0"));
    }
}
