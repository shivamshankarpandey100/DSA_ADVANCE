//https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/description/?envType=daily-question&envId=2024-11-28
class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0}); 
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newDist = dist[x][y] + grid[nx][ny]; 

                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;

                        if (grid[nx][ny] == 0) {
                            deque.addFirst(new int[]{nx, ny});
                        } else {
                            deque.addLast(new int[]{nx, ny}); 
                        }
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
