//https://leetcode.com/problems/valid-arrangement-of-pairs/

import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.computeIfAbsent(start, k -> new Stack<>()).push(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        int startNode = pairs[0][0]; // Default start
        for (int node : outDegree.keySet()) {
            if (outDegree.get(node) > inDegree.getOrDefault(node, 0)) {
                startNode = node;
                break;
            }
        }

        LinkedList<int[]> result = new LinkedList<>();
        dfs(graph, startNode, result);

        int[][] res = new int[result.size()][2];
        int index = 0;
        for (int[] pair : result) {
            res[index++] = pair;
        }
        return res;
    }

    private void dfs(Map<Integer, Stack<Integer>> graph, int node, LinkedList<int[]> result) {
        Stack<Integer> stack = graph.get(node);
        while (stack != null && !stack.isEmpty()) {
            int next = stack.pop();
            dfs(graph, next, result);
            result.addFirst(new int[]{node, next}); 
        }
    }
}
