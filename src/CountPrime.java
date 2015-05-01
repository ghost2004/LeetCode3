import java.util.Arrays;

/*
 * Count the number of prime numbers less than a non-negative number, n
 */
public class CountPrime {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        int out = 0;
        int idx = 2;    //first prime number
        
        boolean flag[] = new boolean[n];
        Arrays.fill(flag, false);
        
        do {
            out++;
            // fill out the multiples of current prime
            for (int i = idx*2; i < n; i += idx) {
                flag[i] = true;
            }
            // looking for the next prime
            do {
                idx++;
            } while(idx < n && flag[idx]);

        } while (idx < n);

        return out;
        
        
    }

}
