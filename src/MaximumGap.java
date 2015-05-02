import java.util.Arrays;

/*
 * Given an unsorted array, find the maximum difference between the successive 
 * elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit 
in the 32-bit signed integer range.
 */
public class MaximumGap {

    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) 
            return 0;
        int maxGap = 0;
        int min = num[0];
        int max = num[0];
        int i;
        int idx;
        // find the max and min value in the array
        for (i = 1; i< num.length; i++) {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }
        // the minimal gap will be (max-min)/len +1
        int gap = (max - min)/num.length + 1;
        // the number of buckets
        int len = (max - min)/gap +1;
        
        // the minimal value of the bucket
        int bucketMin[] = new int[len]; 
        // the maximal value of the bucket
        int bucketMax[] = new int[len];
        // the flag that if the bucket is filled
        boolean bucketFilled[] = new boolean[len];
        
        Arrays.fill(bucketFilled, false);
        
        for (i = 0; i < num.length; i++) {
            // get the bucket number
            idx = (num[i] - min) / gap;
            if (bucketFilled[idx]) {
                // if numbers in this bucket, change the max/min numbers
                bucketMin[idx] = Math.min(bucketMin[idx] , num[i]);
                bucketMax[idx] = Math.max(bucketMax[idx] , num[i]);
            } else {
                // the first element in this bucket
                bucketFilled[idx] = true;
                bucketMin[idx] = num[i];
                bucketMax[idx] = num[i];
            }
        }
        int prev = 0;
        
        // scan the buckets
        for (idx = 1; idx < len;idx++) {
            if (!bucketFilled[idx])
                continue;
            maxGap = Math.max(bucketMin[idx] - bucketMax[prev], maxGap);
            prev = idx;
        }
        
        
        
        return maxGap;
        
    }
    
    public static void main(String[] args) {
        int a6[] = {1, 32,4,1,6,45,3,7,32,8,10,9};
        int a7[] = {1, 32, 32,32};
        MaximumGap m = new MaximumGap();
        System.out.println(m.maximumGap(a7));
        System.out.println(m.maximumGap(a6));
    }

}
