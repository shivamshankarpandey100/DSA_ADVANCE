//https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups

class Solution {
    private boolean check(int start, int[] color, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adjNode : adj.get(node)) {
                if (color[adjNode] == -1) {
                    color[adjNode] = 1 - color[node];
                    q.add(adjNode);
                } else if (color[adjNode] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartite(List<List<Integer>> adj) {
        int V = adj.size();
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 1; i < V; i++) {
            if (color[i] == -1) {
                if (!check(i, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int levelOrder(int start, List<List<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { start, 1 });
        vis[start] = true;
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int[] A = q.poll();
            int node = A[0];
            int level = A[1];
            max = Math.max(max, level);
            for (int adjNode : adj.get(node)) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.offer(new int[] { adjNode, level + 1 });
                }
            }
        }
        return max;
    }

    private int findMaxLevel(int[] level, List<List<Integer>> adj, int start, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        vis[start] = true;
        int max_level = -1;
        while (!q.isEmpty()) {
            int node = q.poll();
            max_level = Math.max(max_level, level[node]);

            for (int adjNode : adj.get(node)) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }
        return max_level;
    }

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        if (!isBipartite(adj)) {
            return -1;
        }
        int[] level = new int[adj.size()];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            level[i] = levelOrder(i, adj);
        }
        boolean[] vis = new boolean[adj.size()];
        int total_level = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                total_level += findMaxLevel(level, adj, i, vis);
            }
        }
        return total_level;
    }
}