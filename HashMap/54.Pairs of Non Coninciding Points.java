

//  https://practice.geeksforgeeks.org/problems/pairs-of-non-coinciding-points4141/1


import java.util.*;
class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        
        HashMap<Integer, Integer> xmap = new HashMap<>();
        HashMap<Integer, Integer> ymap = new HashMap<>();
        HashMap<String, Integer> xymap = new HashMap<>();

        int sum = 0;

        for(int i = 0; i < X.length; i++){
            int x = X[i];
            int y = Y[i];

            String xy = "" + x + "*" + y;

            int xfrq = xmap.getOrDefault(x, 0);
            int yfrq = ymap.getOrDefault(y, 0);
            int xyfrq = xymap.getOrDefault(xy, 0);

            sum += xfrq + yfrq - 2 * xyfrq;

            xmap.put(x, xfrq + 1);
            ymap.put(y, yfrq + 1);
            xymap.put(xy, xyfrq + 1);
        }

        return  sum;
    }
};