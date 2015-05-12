/*
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 
00000010100101000001111010011100), return 964176192 (represented
in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits2(int n) {
        int x = 0;
        int t = n;
        for (int i = 0; i < 32; i++) {
            int m = t & 1;
            // failed in x = (x<<1) + t % 1; --> always zero here
            x = x<<1;
            x += m;
            t = t >>1;
        }
        return x;
    }
    byte tb[] = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
    public int reverseBits(int n) {
        int x = 0;
        int t = n; 
        int mask = 0xf;
        for (int i = 0 ; i < 8; i++) {
            int v = t & mask;
            x = x<<4;
            x += tb[v];
            t = t >> 4;
        }
        
        return x;
    }
    
    public static void main(String args[]) {
        ReverseBits n  =new ReverseBits();
        System.out.println(n.reverseBits(1));


    }
}
