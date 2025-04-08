//https://www.geeksforgeeks.org/problems/bridge-edge-in-graph/1

class Solution {
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); 
        }
        
        return isBridgeUtil(V, adj, c, d) == 1;
    }

    static void bfs(int src, ArrayList<ArrayList<Integer>> adj, int c, int d, boolean check, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            visited[node] = 1;
            for (int next : adj.get(node)) {
                if (check && ((node == c && next == d) || (node == d && next == c))) {
                    continue;
                }
                if (visited[next] != 1) {
                    q.add(next);
                }
            }
        }
    }

    static int isBridgeUtil(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        int[] visited = new int[V];

        Arrays.fill(visited, 0);
        int disjointSets = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                bfs(i, adj, c, d, false, visited);
                disjointSets++;
            }
        }

        Arrays.fill(visited, 0);
        int disjointSets2 = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                bfs(i, adj, c, d, true, visited);
                disjointSets2++;
            }
        }

        if (disjointSets != disjointSets2) {
            return 1; 
        }
        return 0; 
    }
}