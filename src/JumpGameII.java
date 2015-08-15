import java.util.Arrays;

/*
 * Given an array of non-negative integers, you are initially positioned
 *  at the first index of the array.

Each element in the array represents your maximum jump length at that
 position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. 
(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {
    //Greedy solution
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        // counter for minimal steps
        int steps = 0;
        // left pointer of window, start with 0
        int left = 0;
        // right pointer of window, start with 0
        int right = 0;
        // the max index we can reach so far
        int reach = 0;
        // keep looping when right index did not reach the end
        while (right <nums.length-1) {
            // for all the elements in current window
            while (left <= right) {
                // update max pointer we can reach 
                reach = Math.max(reach, left + nums[left]);
                //slide the window to left
                left++;
            }
            // all of above can be done in one step
            steps++;
            // right side of window is max index we can reach so far 
            right = reach;
        }
        
        return steps;
    }
    
    public static void main(String args[]) {
        JumpGameII j = new JumpGameII();
        int t1[] = {2,3,1,1,4};
        System.out.println(j.jump(t1));
    }
}

class JumpGameIITimeExceed {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int steps[] = new int[nums.length];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;
        for (int i = 0 ; i < nums.length-1; i++) {
            int j = 1 ;
            while (j <= nums[i] && i+j < nums.length) {
                if (i+j >= nums.length -1)
                    return steps[i]+1;
                steps[i+j] = Math.min(steps[i]+1, steps[i+j]);
                j++;
            }
        }
        
        return steps[nums.length-1];
    }
}