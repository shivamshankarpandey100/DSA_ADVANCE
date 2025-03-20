//https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/

import java.util.*;

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int[] component = new int[n];
        Arrays.fill(component, -1);
        int[] minAndCost = new int[n];
        Arrays.fill(minAndCost, Integer.MAX_VALUE);

        int compId = 0;
        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                bfs(graph, i, component, compId, minAndCost);
                compId++;
            }
        }

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int si = query[i][0], ti = query[i][1];
            if (component[si] != component[ti]) {
                result[i] = -1;
            } else {
                result[i] = minAndCost[si];
            }
        }
        return result;
    }

    private void bfs(Map<Integer, List<int[]>> graph, int start, int[] component, int compId, int[] minAndCost) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        component[start] = compId;

        int minAnd = Integer.MAX_VALUE;
        Map<Integer, Integer> visitedAnd = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, Integer.MAX_VALUE});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], andCost = curr[1];

            if (visitedAnd.containsKey(node) && visitedAnd.get(node) <= andCost) continue;
            visitedAnd.put(node, andCost);

            minAnd = Math.min(minAnd, andCost);
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0], edgeWeight = neighbor[1];
                pq.offer(new int[]{nextNode, andCost & edgeWeight});
            }
        }

        for (int node : visitedAnd.keySet()) {
            minAndCost[node] = minAnd;
            component[node] = compId;
        }
    }
}
