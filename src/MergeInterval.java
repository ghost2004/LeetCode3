import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
public class MergeInterval {
    static final Comparator<Interval> Interval_compare = new Comparator<Interval>() { 
        public int compare(Interval left, Interval right) {
            if (left.start < right.start)
                return -1;
            else if (left.start > right.start)
                return 1;
            return 0;
        }
    };

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() < 2)
            return intervals;
        Collections.sort(intervals, Interval_compare);
        int size = intervals.size();
        Interval tmp = intervals.get(0);
        for (int i = 1; i < size; i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= tmp.end) {
                tmp.end = Math.max(tmp.end, cur.end);
            } else if (cur.start > tmp.end) {
                result.add(new Interval(tmp.start, tmp.end));
                tmp = cur;
            }
        }
        result.add(new Interval(tmp.start, tmp.end));
        return result;
    }
}
