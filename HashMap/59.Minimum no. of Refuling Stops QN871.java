

//  https://leetcode.com/problems/minimum-number-of-refueling-stops/


import java.util.*;
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        int range = startFuel;
        int i = 0;
        int pumps = 0;

        while(range < target){
            while(i < stations.length){
                if(stations[i][0] <= range){
                    q.add(stations[i][1]);
                }else{
                    break;
                }
                i++;
            }

            if(q.size() == 0){
                return -1;
            }

            range += q.remove();
            pumps++;
        }

        return pumps;

    }
}