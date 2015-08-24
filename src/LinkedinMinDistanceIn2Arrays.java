/*
 * Interview questions from Linkedin
 * 
 * find  min distance between elements across two sorted arrays
 */
public class LinkedinMinDistanceIn2Arrays {


    public static void main(String [] args)
    {
        int [] array1 = {12, 34, 57, 61, 69, 80};
        int [] array2 = {27, 39, 48, 51, 79};
        int a1[] = {1, 4, 5, 6};
        int a2[] = { 100,200};
        System.out.println(findMinDiff(array1,array2));
        System.out.println(findMinDiff(a1,a2));
    }
    public static int findMinDiff(int[] array1, int[] array2)
    {
        int i = 0, j = 0;
        int minDiff = Integer.MAX_VALUE;

        while ( i < array1.length && j < array2.length )
        {
            if( array1[i] == array2[j] )
                return 0;

            int diff = Math.abs( array1[i] - array2[j] );
            minDiff = Math.min( diff, minDiff );

            if( array1[i] > array2[j] )
                j++;
            else
                i++;

        }

        if( i < array1.length ) //array1 has some more elements
        {
            j--; // j has reached the end, move it to last element
            while ( i < array1.length )
            {
                int diff = Math.abs( array1[i] - array2[j] );
                minDiff = Math.min( diff, minDiff );
                i++;
            }
        }
        else //array2 has some more elements
        {
            i--;
            while ( j < array2.length )
            {
                int diff = Math.abs( array1[i] - array2[j] );
                minDiff = Math.min( diff, minDiff );
                j++;
            }
        }
        return minDiff;
    }
}
