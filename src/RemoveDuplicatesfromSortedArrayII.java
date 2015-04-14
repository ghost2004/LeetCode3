/*
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int curVal = A[0];
        int curCnt = 1;
        int read = 1;
        int write = 1;
        
        for (read = 1; read < A.length; read++) {
            
            if (read != write) {
                A[write] = A[read];
            }
            if (A[read] == curVal) {
                if (curCnt < 2) {
                    curCnt++;
                    write++;
                } 
            } else {
                curVal = A[read];
                curCnt = 1;
                write++;
            }
            
            
        }
        
        return write;
    }
    public static void printArray(int a[], int b) {
        for (int i = 0; i < b; i++) {
            System.out.print(a[i]+" ");
            
        }
        System.out.println();
    }
    public static void main(String args[]) {
        RemoveDuplicatesfromSortedArrayII r = new RemoveDuplicatesfromSortedArrayII();
        int b1[] ={1};
        int b = r.removeDuplicates(b1);
        printArray(b1,b);
        int a1[] ={1,1};
        int a = r.removeDuplicates(a1);
        printArray(a1,a);
    }
}
