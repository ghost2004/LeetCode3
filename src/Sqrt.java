/*
 * Implement int sqrt(int x).

Compute and return the square root of x.
 */
public class Sqrt {
    public int mySqrt(int x) {
        long start = 0;
        long end = x/2+1;
        
        while (start <= end) {
            long mid = (start+end)/2;
            long t = mid*mid;
            if (t == x)
                return (int)mid;
            else if (t > x)
                end = mid - 1;
            else 
                start = mid+1;
               
            
        }
        
        return (int)end;
    }

}
