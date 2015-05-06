/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge
 *  if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
import java.util.*;

public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        ArrayList<Interval> out = new ArrayList<Interval>();
        
        if (intervals == null || intervals.size() == 0) {
            out.add(newInterval);
            return out;
        }
            
        int idx = 0;
        int len = intervals.size();
        Interval t = newInterval;
        for (idx = 0; idx < len; idx++) {
            Interval p = intervals.get(idx);
            if (p.end < t.start) {
                out.add(p);
            } else if (t.end < p.start) {
                out.add(t);
                t = p;
            } else {
                t.start = Math.min(t.start, p.start);
                t.end = Math.max(t.end, p.end);
            }
        }
        
        out.add(t);
        return out;
        
    }
}
