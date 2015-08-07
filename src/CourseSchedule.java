/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you
 should also have finished course 1. So it is impossible.
 */
import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;
        int i;
        int noPre = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        // counter for each course's prerequisites number
        int pCounter[] = new int[numCourses];
        
        // scan prerequisites and save the number of each course's prerequisites number
        for (i = 0; i < prerequisites.length; i++) {
            pCounter[prerequisites[i][0]]++;
        }
        
        // zero counter means no prerequisites, push it into queue
        for (i = 0; i < numCourses; i++ ) {
            if (pCounter[i] == 0) {
                queue.offer(i);
                noPre++;
            }
        }
        
        // BFS
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == index) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        // this course is good for prerequisites
                        queue.offer(prerequisites[i][0]);
                        noPre++;
                    }
                }
            }
        }
        
        return noPre == numCourses;
    }
}
