/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int len = A.length;
        
        int read = 0;
        int write = 0;
        
        do {
            if (read != write) {
                A[write] = A[read];
            }
            if (A[read] != elem)
                write++;
            read++;
        } while (read < len);
        
        return write;
        
    }

}
