/*
 * Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
import java.util.*;
public class SummaryRanges {
    private String getStringRange(int begin, int end) {
        String s = "";
        if (begin == end) {
            s += begin;
        } else {
            s += begin+"->"+end;
        }
        
        return s;
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> out = new ArrayList<String>();
        if (nums == null || nums.length == 0)
            return out;
        String s;
        int begin = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != end+1) {
                s = getStringRange(begin, end);
                out.add(s);
                begin = nums[i];
                end = nums[i];
            } else {
                end = nums[i];
            }
        }
        s = getStringRange(begin, end);
        out.add(s);
        return out;
    }

}
