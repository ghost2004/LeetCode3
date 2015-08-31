/*
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        
        // build up factor array for each n!
        int factor[] = new int[n];
        factor[0] = 1;
        for (int i = 1; i < n;i++) 
            factor[i] = factor[i-1] * i;
        StringBuilder sb = new StringBuilder();
        
        
        
        return sb.toString();
    }
}
