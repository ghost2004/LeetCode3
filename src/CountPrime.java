import java.util.Arrays;

/*
 * Count the number of prime numbers less than a non-negative number, n
 */
public class CountPrime {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        int out = 1;
        int idx = 2;
        
        boolean flag[] = new boolean[n];
        Arrays.fill(flag, false);
        
        while (idx < n) {
            for (int i = idx*2; i < n; i += idx) {
                flag[i] = true;
            }
            do {
                idx++;
            } while(idx < n && flag[idx]);
            
            if (idx < n)
                out++;
            
        }
        
        
        
        
        return out;
        
        
    }

}
