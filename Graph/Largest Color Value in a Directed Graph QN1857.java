//https://leetcode.com/problems/largest-color-value-in-a-directed-graph/

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        
        // Build graph and compute in-degrees
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        // colorCount[node][color] -> max count of 'color' on any path to node
        int[][] colorCount = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all nodes with in-degree 0
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            // Update the count for current node's color
            int colorIndex = colors.charAt(node) - 'a';
            colorCount[node][colorIndex]++;
            maxColorValue = Math.max(maxColorValue, colorCount[node][colorIndex]);

            for (int neighbor : graph.get(node)) {
                // Update color counts for the neighbor
                for (int c = 0; c < 26; c++) {
                    colorCount[neighbor][c] = Math.max(colorCount[neighbor][c], colorCount[node][c]);
                }

                // Decrease in-degree and add to queue if 0
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return visited == n ? maxColorValue : -1;  // Check for cycle
    }
}
