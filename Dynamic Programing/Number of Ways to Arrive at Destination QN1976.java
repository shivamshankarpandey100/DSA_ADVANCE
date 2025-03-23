//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        
        // Graph representation as adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        // Min heap (priority queue) -> [time, node]
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); // {time, node}
        
        // Distance array (initially set to max value)
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        // Ways array
        int[] ways = new int[n];
        ways[0] = 1;
        
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long time = current[0];
            int u = (int) current[1];
            
            // Skip if we have already found a shorter path
            if (time > dist[u]) continue;
            
            // Explore neighbors
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                long newTime = time + neighbor[1];
                
                if (newTime < dist[v]) {
                    dist[v] = newTime;
                    ways[v] = ways[u];
                    pq.offer(new long[]{newTime, v});
                } else if (newTime == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        
        return ways[n - 1];
    }
}
