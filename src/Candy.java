/*
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        if (ratings.length == 1)
            return 1;
        int len = ratings.length;
        int leftC[] = new int[len];
        
        int minC = 0;
        leftC[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1])
                leftC[i] =  leftC[i-1] + 1;
            else 
                leftC[i] = 1;
        }
        
        int rightC = 1;
       
        minC += Math.max(rightC, leftC[len-1]);
        
        for(int i = len-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1])
                rightC += 1;
            else 
                rightC = 1;
            minC += Math.max(rightC, leftC[i]);
        }
        
        return minC;
    }
}
