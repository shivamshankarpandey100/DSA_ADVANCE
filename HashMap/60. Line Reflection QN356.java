

//    https://leetcode.com/problems/line-reflection/description/


import java.util.*;
class Main{

  public static boolean isReflected(int[][] points) {

    HashSet<String> set = new HashSet<>();
    int xmin = points[0][0];
    int xmax = points[0][0];
    set.add(points[0][0] + "#" + points[0][1]);

    for (int i = 1; i < points.length; i++) {
      set.add(points[i][0] + "#" + points[i][1]);
      xmin = Math.min(xmin, points[i][0]);
      xmax = Math.max(xmax, points[i][0]);
    }

    int twiceXmirr = xmax + xmin;

    for (int i = 0; i < points.length; i++) {
      int x = points[i][0];
      int y = points[i][1];
      int ximg = twiceXmirr - x;
      int yimg = y;

      if (set.contains(ximg + "#" + yimg) == false) {
        return false;
      }

    }

    return true;

  }
}