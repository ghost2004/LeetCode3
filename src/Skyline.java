/*
 * A city's skyline is the outer contour of the silhouette formed by all the 
 * buildings in that city when viewed from a distance. Now suppose you are 
 * given the locations and height of all the buildings as shown on a city
 * scape photo (Figure A), write a program to output the skyline formed by
 *  these buildings collectively (Figure B).

 Buildings  Skyline Contour
The geometric information of each building is represented by a triplet of 
integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and
 right edge of the ith building, respectively, and Hi is its height. It is 
 guaranteed that 0 ¡Ü Li, Ri ¡Ü INT_MAX, 0 < Hi ¡Ü INT_MAX, and Ri - Li > 0. 
 You may assume all buildings are perfect rectangles grounded on an 
 absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: 
[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of 
[ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key
 point is the left endpoint of a horizontal line segment. Note that the last
  key point, where the rightmost building ends, is merely used to mark the 
  termination of the skyline, and always has zero height. Also, the ground in 
  between any two adjacent buildings should be considered part of the skyline
   contour.

For instance, the skyline in Figure B should be represented as:
[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. 
For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three l
ines of height 5 should be merged into one in the final output as such: 

[...[2 3], [4 5], [12 7], ...]
 */
import java.util.*;
public class Skyline {
    
    // Edge Class of all the edges of building
    // x means position
    // when building starts here the height is positive number
    // when building ends here the height is negative number
   
    public class Edge {
        int x;
        int height;

        public Edge(int x, int h) {
            this.x = x;
            this.height = h;
        }
    }
    
    // Comparator for edge class
    static final Comparator<Edge> Edge_compare = new Comparator<Edge>() {
        public int compare(Edge a, Edge b) {
            // first compare the x position
            // make sure we can scan the buildings from left to right
            if (a.x != b.x)
                return Integer.compare(a.x, b.x);
            
            // then compare the height, but here is the trick
            // we want positive number (start) in front of negative (end) one
            // for case like [0,2,3] [2,5,3], at x = 2 one building ends and another rises
            // we need to handle rising one first.
            return Integer.compare(b.height, a.height);
        }
    };
    
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0)
            return res;
        
        Edge edges[] = new Edge[buildings.length*2];
        
        // build the edges array
        for (int i = 0; i < buildings.length; i++) {
            // start height is positive, while end height is negative
            edges[2*i] = new Edge(buildings[i][0],buildings[i][2]);
            edges[2*i+1] = new Edge(buildings[i][1], -buildings[i][2]);
        }
        
        // sort the edges array
        Arrays.sort(edges, Edge_compare);
        // we need max heap here, to get the highest height
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(buildings.length, Collections.reverseOrder());
        // add horizon line first
        heap.offer(0);
        // the height before 
        int prev = 0;
        for (int i = 0; i < buildings.length*2; i++) {
            
            if (edges[i].height > 0) {
                // new building rises, add the height into heap
                heap.add(edges[i].height);
            } else {
                // buildings ends here, remove it from heap
                heap.remove(-edges[i].height);
            }
            // get the current height of skyline
            int cur = heap.peek();
            if (cur != prev) {
                // add it into result if it is different from previous one
                prev = cur;
                res.add(new int[] {edges[i].x, cur});
            }
        }
        
        return res;
    }
}
