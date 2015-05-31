/*
 * Given a list of non negative integers, arrange 
 * them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest 
formed number is 9534330.

Note: The result may be very large, so you need to
 return a string instead of an integer.
 */
import java.util.Arrays;
import java.util.Comparator;
public class LargestNumber {
    static final Comparator<String> Str_Cmp = new Comparator<String>() {
        public int compare(String left, String right) {
            String leftRight = left.concat(right);
            String rightLeft = right.concat(left);
            return rightLeft.compareTo(leftRight);
        }
    };
    public String largestNumber(int[] nums) {
        String n[] = new String[nums.length];
        for (int i = 0; i < nums.length;i++) {
            n[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(n, Str_Cmp);
        
        String out = "";
        for (int i = 0; i < nums.length;i++) {
            out+=n[i];
        }
        
        int idx = 0;
        while (idx < out.length() && out.charAt(idx) == '0') 
            idx++;
        if (idx == out.length())
            return "0";
        return out.substring(idx);
    }
    
    public static void main(String args[]) {
        LargestNumber l = new LargestNumber();
        int a1[] ={0,0};
        System.out.println(l.largestNumber(a1));
    }
}
