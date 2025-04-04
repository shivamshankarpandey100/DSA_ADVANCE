//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        boolean visited[] = new boolean[V];
        
        List<Integer>[] adjacencyList = new ArrayList[V];
        
        for (int i = 0; i < V; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }
        
        for (int edge[]: edges) {
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }
        
        for (int i = 0; i < V; i++) {
            if (hasCycle(i, -1, adjacencyList, visited)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean hasCycle(int v, int parent, List<Integer>[] adjacencyList, boolean visited[]) {
        if (visited[v]) {
            return true;
        }
        
        visited[v] = true;
        for (int neighbour: adjacencyList[v]) {
            if (neighbour == parent) continue;
            if (hasCycle(neighbour, v, adjacencyList, visited)) return true;
        }
        visited[v] = false;
        
        return false;
    }
}