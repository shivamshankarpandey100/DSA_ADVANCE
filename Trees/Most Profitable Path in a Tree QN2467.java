//https://leetcode.com/problems/most-profitable-path-in-a-tree/

import java.util.*;

class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] bobPath = new int[n];
        Arrays.fill(bobPath, -1);
        ArrayList<Integer> path = new ArrayList<>();
        findBobPath(bob, -1, path, graph);
        
        for (int i = 0; i < path.size(); i++) {
            bobPath[path.get(i)] = i;
        }
        
        // Memoization for optimal subproblems
        Map<Integer, Integer> memo = new HashMap<>();
        return getAliceMaxScore(0, -1, 0, bobPath, graph, 0, amount, memo);
    }

    private boolean findBobPath(int node, int parentNode, ArrayList<Integer> path, ArrayList<Integer>[] graph) {
        if (node == 0) return true;
        for (int neighbor : graph[node]) {
            if (neighbor != parentNode) {
                path.add(node);
                if (findBobPath(neighbor, node, path, graph)) return true;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    private int getAliceMaxScore(int node, int parentNode, int currScore, int[] bobPath, ArrayList<Integer>[] graph, int timestamp, int[] amount, Map<Integer, Integer> memo) {
        int key = node * 1000 + timestamp; // Unique key for memoization
        if (memo.containsKey(key)) return memo.get(key);
        
        if (bobPath[node] == -1 || bobPath[node] > timestamp) {
            currScore += amount[node];
        } else if (bobPath[node] == timestamp) {
            currScore += amount[node] / 2;
        }
        
        if (graph[node].size() == 1 && node != 0) {
            memo.put(key, currScore);
            return currScore;
        }
        
        int maxScore = Integer.MIN_VALUE;
        for (int neighbor : graph[node]) {
            if (neighbor != parentNode) {
                maxScore = Math.max(maxScore, getAliceMaxScore(neighbor, node, currScore, bobPath, graph, timestamp + 1, amount, memo));
            }
        }
        
        memo.put(key, maxScore);
        return maxScore;
    }
}
