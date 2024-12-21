//https://leetcode.com/problems/maximum-number-of-k-divisible-components

import java.util.*;

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        int[] componentCount = new int[1]; 
        boolean[] visited = new boolean[n];

        dfs(0, tree, values, k, visited, componentCount);
        return componentCount[0];
    }

    private int dfs(int node, List<List<Integer>> tree, int[] values, int k, boolean[] visited, int[] componentCount) {
        visited[node] = true;

        int subtreeModSum = values[node] % k;

        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                int childModSum = dfs(neighbor, tree, values, k, visited, componentCount);
                subtreeModSum = (subtreeModSum + childModSum) % k;
            }
        }

        if (subtreeModSum == 0) {
            componentCount[0]++;
            return 0; 
        }

        return subtreeModSum; 
    }
}
