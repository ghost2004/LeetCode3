/*
 * Implement pow(x, n).
 */
public class Pow {

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return x;
        boolean negative = n < 0 ? true: false;
        if (negative)
            n = -n;
        
        double tmp = myPow(x, n/2);
        
        if (n%2 == 0) {
            tmp *= tmp;
        } else {
            tmp *= tmp*x;
        }
        
        if (negative) {
            tmp = 1/tmp;
        }
        return tmp;
    }

    
    public static void main(String args[]) {
        Pow p = new Pow();
        System.out.println(p.myPow(2, 6));
        System.out.println(p.myPow(1, -2147483648));
    }
}
