/*
 * Given an array of size n, find the majority element. 
 * 
 * The majority element is the element that appears more than n/2 times
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElements {
    public int majorityElement(int[] num) {
        if (num.length == 1)
            return num[0];
        
        int candidate = num[0];
        int vote = 1;
        
        for (int i = 1; i < num.length; i++) {
            if (num[i] == candidate) {
                vote++;
            } else {
                vote--;
            }
            if (vote <= 0){
                candidate = num[i];
                vote = 1;
            }
        }
        
        return candidate;
                
        
    }

}
