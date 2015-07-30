/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 *  find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
 */
import java.util.Stack;
public class LargestRectInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length < 1)
            return 0;
        int max = 0;
        int idx = 0;
        // create stack for all increasing bars 
        Stack<Integer> stack = new Stack<Integer>();
        // let's take following array as an example
        // index    0   1   2   3   4   5
        // value    2   1   5   6   2   3
        // scan the array
        while (idx < height.length) {
            
            if (stack.isEmpty() || height[idx] >= height[stack.peek()]) {
                // the bar is higher than the item in stack, push it into stack
                stack.push(idx);
                idx++;
            } else {
                // get the bar on top of the stack
                int h = height[stack.pop()];
                int width = 0;
                if(stack.isEmpty()) {
                    /* no other elements in stack, so the width is current index
                     * in above example, the stack will pop up when index is 1, 
                     * we are calculating the first block at index 0
                     *        stack
                     *          |
                     *          v
                     * index    0   1   2   3   4   5
                     * value    2   1   5   6   2   3
                     *              ^
                     *              |
                     *             index
                     * 
                     */
                    width = idx;
                } else {
                    /* There are still elements in stack, 
                     * so the width is the difference between current index and last index
                     * in above example, the stack will pop up when index is 4, 
                     * we are calculating the block at index 3, area is 1x6 = 6
                     *           stack peek pop
                     *              |   |   |
                     *              v   v   v
                     * index    0   1   2   3   4   5
                     * value    2   1   5   6   2   3
                     *                          ^
                     *                          |
                     *                        index
                     * for the next loop,  index 2 is popped up because 5 > 2    
                     * we are calculating the block at index 2-3, area is 2x5 = 10                     
                     *            peek pop 
                     *              |   |   
                     *              v   v   
                     * index    0   1   2   3   4   5
                     * value    2   1   5   6   2   3
                     *                          ^
                     *                          |
                     *                        index                                            
                     *
                     */             
                    width = idx - stack.peek() - 1;
                }
                
                max = Math.max(max, width*h);
            }
        }
        while (!stack.isEmpty()) {
            /*
             * same scenario, at the end of it 
             *           stack        peek pop
             *              |           |   |
             *              v           v   v
             * index    0   1   2   3   4   5
             * value    2   1   5   6   2   3
             *                              ^
             *                              |
             *                           index
             * Finally it will be                           
             *             pop
             *              | 
             *              v   
             * index    0   1   2   3   4   5
             * value    2   1   5   6   2   3
             *                              ^
             *                              |
             *                           index    
             *  And we are calculating the block at index 1-5, area is 1x5 = 5                                             
             *                           
             */ 
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? idx : idx - stack.peek() - 1;
            max = Math.max(h * w, max);
        }
        return max;
    }

}
