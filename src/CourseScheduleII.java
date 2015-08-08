/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to 
first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the 
ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If 
it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished 
course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished 
both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency
 matrices. Read more about how a graph is represented.
 */
import java.util.*;
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int res[] = new int[numCourses];
        if (prerequisites == null)
            return res;
        //if there is no prerequisites, return a sequence of courses
        if(prerequisites.length == 0){
            for(int m=0; m<numCourses; m++){
                res[m]=m;
            }
            return res;
        }
     
        int pCounter[] = new int[numCourses];
        int i;
        int noPre = 0;
        int idx = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (i = 0; i < prerequisites.length;i++ ) {
            pCounter[prerequisites[i][0]]++;
        }
        
        for (i = 0; i < numCourses;i++ ) {
            if (pCounter[i] == 0) {
                noPre++;
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[idx++] = node;
            
            for (i = 0 ; i < prerequisites.length; i++){
                if (prerequisites[i][1] == node) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        noPre++;
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        
        if (noPre != numCourses)
            return new int[0];
        
        return res;
        
    }
}
