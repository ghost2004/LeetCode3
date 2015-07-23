/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute 
 * how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int len = height.length;
        int trap = 0;
        // the highest bar from left side
        int leftMax[] = new int[len];
        int i;
        // Scan from left to right, recode the highest bar from left
        leftMax[0] = 0;
        int leftBar = height[0];
        for (i = 1; i < len - 1; i++) {
            leftBar = Math.max(leftBar, height[i]);
            leftMax[i] = leftBar;
        }
        
        // Scan from right to left
        int rightBar = height[len-1];
        for (i = len-2; i > 0;i--) {
            //                  |
            //   |              |
            //   |        |     |
            //  leftbar  cur    rightBar
            //  the volume of this point is the difference between
            //   minbar and this height 
            int d = Math.min(leftMax[i], rightBar) - height[i];
            if (d > 0)
                trap += d;
            // update the height of rightBar for next element        
            rightBar = Math.max(rightBar, height[i]);        
        }
        
        return trap;
    }
}
