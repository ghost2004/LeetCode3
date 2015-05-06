/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

import java.util.HashMap;
public class MaxPtOnLine {
    public int maxPoints(Point[] points) {
        int max = 1;
        if (points == null)
            return 0;
        if (points.length <= 2)
            return points.length;
        
        
        HashMap<Double, Integer> map;
        int length = points.length;
        
        for (int i = 0; i < length;i++){
            int duplicate = 0;
            map = new HashMap<Double, Integer>();
            int t_max = 0;
            int vert_num = 0;
            for (int j = 0; j < length; j++) {
                if (i == j)
                    continue;
                if (points[i].x == points[j].x && points[i].y == points[j].y)
                    duplicate++;
                else  if (points[i].x == points[j].x) {
                    vert_num++;
                    t_max = Math.max(t_max, vert_num);
                } else {
                    Double ang = new Double((points[j].y - points[i].y)*1.0/(points[j].x - points[i].x));
                    Integer cnt = map.get(ang);
                    if (cnt == null) {
                        map.put(ang, 1);
                        t_max = Math.max(t_max, 1);
                    } else {
                        map.put(ang, cnt+1);
                        t_max = Math.max(t_max, cnt+1);
                    }
                }
                
            }
            max = Math.max(max, duplicate+t_max+1);
        }
        return max;
    }
    
    public static void main(String[] args) {
        Point t1[] = {new Point(84,250), new Point(0,0),new Point(1,0),new Point(0,-70),
                new Point(0,-70),new Point(1,-1),new Point(21,10),new Point(42,90),new Point(-42,-230)};
        Point t2[] = {new Point(2,3), new Point(3,3), new Point(-5,3)};
        Point t3[] = {new Point(3,1), new Point(3,1), new Point(12,3), new Point(-6,-1)};
        MaxPtOnLine m = new MaxPtOnLine();
        System.out.println(m.maxPoints(t3));
        //System.out.println(m.maxPoints(t2));
    }

}
