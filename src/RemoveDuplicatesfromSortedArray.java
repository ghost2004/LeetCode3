/*
 * Given a sorted array, remove the duplicates in place such that each element 
 * appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with 
constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] A) {
        
        if (A == null || A.length == 0)
            return 0;
        int read = 1;
        int write = 1;
        
        for (read = 1; read < A.length; read++) {
            if (A[read] == A[read-1])
                continue;
            if (read != write) {
                A[write] = A[read];
               
            }
            write++;
        }
        
        return write;
    }
}
