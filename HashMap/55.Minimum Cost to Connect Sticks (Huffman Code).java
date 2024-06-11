

// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1


import java.util.*;
class Main{

    public static int connectSticks(int[] sticks) {

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();//create a priority queue
        for (int stick : sticks){//add all the sticks to the queue
            q.add(stick);//add the stick to the queue
        }

        int cost = 0;

        while (q.size() > 1) {
            int stick1 = q.remove();//remove the smallest stick
            int stick2 = q.remove();//remove the second smallest stick
            int sum = stick1 + stick2;//add the two sticks
            cost += sum;//add the sum to the cost
            q.add(sum);//add the sum to the queue
        }

        return cost;//return the cost
    }
}
// for gfg question solutation
class Solution {
    long minCost(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (long rope : arr) {
            pq.add(rope);
        }
        
        long totalCost = 0;
        
       while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();
            
            long cost = first + second;
            
            totalCost += cost;
            
            pq.add(cost);
        }
        
        return totalCost;
    }
}
