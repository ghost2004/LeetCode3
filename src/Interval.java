
public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    
    public static Interval[] getFromArray(int start[], int end[]){
        if (start == null || end == null || start.length != end.length)
            return null;
        
        Interval[] out = new Interval[start.length];
        
        for (int i = 0; i < start.length; i++) { 
            out[i] = new Interval(start[i], end[i]);
        }
        
        return out;
    }
}
