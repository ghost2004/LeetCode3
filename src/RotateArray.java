import java.util.Arrays;

/*
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    // Solution with O(1) space
    private void reverse(int[] nums, int begin,int end) {
        int tmp;
        while (begin < end) {
            tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;
            begin++;
            end--;
        }
       
    }
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        int l = nums.length;
        int s = k % l;
        
        if (s == 0)
            return;
        
        reverse(nums, 0 , l-1);
        reverse(nums, 0, s-1);
        reverse(nums, s, l-1);
    }
    
    // Solution with O(n) space
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        int l = nums.length;
        int s = k % l;
        
        if (s == 0)
            return;
        
        int num2[] =  Arrays.copyOf(nums, l);
        
        for (int i = 0; i < l; i++) {
            nums[(i+s)%l] = num2[i];
        }
       
        
    }
    
    
}
