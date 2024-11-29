//https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/description

// Time Complexity: O(N*M) where N is the number of rows and M is the number of columns
import java.util.PriorityQueue;

class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); 
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
 boolean[][] visited = new boolean[m][n];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0], row = current[1], col = current[2];

            if (visited[row][col]) continue;
            visited[row][col] = true;

            if (row == m - 1 && col == n - 1) return time;

             for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    int nextTime = time + 1;

                    if (nextTime < grid[newRow][newCol]) {
                        int waitTime = grid[newRow][newCol] - nextTime;

                        if (waitTime % 2 != 0) {
                            waitTime += 1;
                        }
                        nextTime += waitTime;
                    }

                    pq.offer(new int[]{nextTime, newRow, newCol});
                }
            }
        }

        return -1;
    }
}
