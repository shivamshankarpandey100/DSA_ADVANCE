//https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> balls = new HashMap<>();
        Map<Integer, Integer> colors = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (balls.containsKey(ball)) {
                int prevColor = balls.get(ball);
                colors.put(prevColor, colors.get(prevColor) - 1);
                
                if (colors.get(prevColor) == 0) {
                    set.remove(prevColor);
                }
            }

            balls.put(ball, color);
            colors.put(color, colors.getOrDefault(color, 0) + 1);
            set.add(color);

            result[i] = set.size();
        }

        return result;
    }
}