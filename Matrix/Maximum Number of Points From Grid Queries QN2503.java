//https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int k = queries.length;
        
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[] answer = new int[k];
        boolean[][] visited = new boolean[m][n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0}); 
        visited[0][0] = true;
        
         int[][] sortedQueries = new int[k][2];
        for (int i = 0; i < k; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        int points = 0;
        
        for (int i = 0; i < k; i++) {
            int query = sortedQueries[i][0];
            int index = sortedQueries[i][1];

            while (!pq.isEmpty() && pq.peek()[0] < query) {
                int[] cell = pq.poll();
                int r = cell[1], c = cell[2];

                points++; 
                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        pq.offer(new int[]{grid[nr][nc], nr, nc});
                    }
                }
            }
            
            answer[index] = points;
        }
        
        return answer;
    }
}
