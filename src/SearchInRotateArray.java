/*
 * Suppose a sorted array is rotated at some pivot unknown to 
 * you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index,
 otherwise return -1.

You may assume no duplicate exists in the array.
 */
public class SearchInRotateArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;
        int leftIdx = 0;
        int rightIdx = A.length-1;
        
        while (leftIdx <= rightIdx) {
            int mid = leftIdx +  (rightIdx - leftIdx )/2;
            if (A[mid] == target)
                return mid;
            
            if (A[leftIdx] <= A[mid]) {
                // left part is sorted
                if (target < A[mid] && target >= A[leftIdx]) {
                    rightIdx = mid - 1;
                } else {
                    leftIdx = mid + 1;
                }
            } else {
                //right part is sorted
                if (target > A[mid] && target <= A[rightIdx]) {
                    leftIdx = mid + 1;
                } else {
                    rightIdx = mid - 1; 
                }
            }
        }
        
        return -1;
        
    }

}
