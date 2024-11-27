//https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/?envType=daily-question&envId=2024-11-27

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new int[]{i + 1, 1});
        }
        
        int[] result = new int[queries.length];
        
        for (int k = 0; k < queries.length; k++) {
            int u = queries[k][0];
            int v = queries[k][1];
            
            graph.get(u).add(new int[]{v, 1});
            
            result[k] = dijkstra(graph, n);
        }
        
        return result;
    }
    
    private int dijkstra(List<List<int[]>> graph, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[0] = 0;
        pq.add(new int[]{0, 0}); // {city, distance}
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int city = current[0];
            int distance = current[1];
            
            if (distance > dist[city]) continue;
            
            for (int[] neighbor : graph.get(city)) {
                int nextCity = neighbor[0];
                int weight = neighbor[1];
                
                if (dist[city] + weight < dist[nextCity]) {
                    dist[nextCity] = dist[city] + weight;
                    pq.add(new int[]{nextCity, dist[nextCity]});
                }
            }
        }
        
        return dist[n - 1];
    }
}
