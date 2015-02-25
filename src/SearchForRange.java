/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class SearchForRange {
    public int[] searchRange(int[] A, int target) {
        int out[] = new int[2];
        int begin = -1;
        int end = -1;
        
        int left = 0;
        int right = A.length-1;
        
        while (left <= right) {
            int mid = (left+right)/2;
            int key = A[mid];
            if (key == target) {
                int i = mid;

                while (i>=0 && A[i] == target)
                    i--;
                begin = i+1;
                i = mid; 
                while (i < A.length && A[i] == target)
                    i++;
                end = i-1;
                break;
            } else  if (key < target) {
                left = mid+1;
            } else {
                right = mid -1 ;
            }
        }
        
        out[0] = begin;
        out[1] = end;
        return out;
    }
    
    public static void main(String[] arg) {
        SearchForRange s = new SearchForRange();
        int A[] = {1};
        int out[] = s.searchRange(A, 1);
        System.out.println(out[0]+","+out[1]);
    }
}
