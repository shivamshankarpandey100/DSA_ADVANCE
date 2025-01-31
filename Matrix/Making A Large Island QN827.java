//https://leetcode.com/problems/making-a-large-island

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int maxArea = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int[][] group = new int[n][n];
        Map<Integer, Integer> areaMap = new HashMap<>();
        int groupId = 2;
        
        // Find all groups (islands) and their area
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && group[i][j] == 0) {
                    int area = dfs(grid, group, i, j, groupId, directions);
                    areaMap.put(groupId++, area);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        // Check for the maximum area by changing one 0 to 1
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    Set<Integer> seenGroups = new HashSet<>();
                    int newArea = 1; // Changing 0 to 1
                    
                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        
                        if (x >= 0 && x < n && y >= 0 && y < n && group[x][y] > 1) {
                            seenGroups.add(group[x][y]);
                        }
                    }
                    
                    for (int g : seenGroups) {
                        newArea += areaMap.get(g);
                    }
                    
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int[][] grid, int[][] group, int i, int j, int groupId, int[][] directions) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == 0 || group[i][j] > 0) {
            return 0;
        }
        
        group[i][j] = groupId;
        int area = 1;
        
        for (int[] dir : directions) {
            area += dfs(grid, group, i + dir[0], j + dir[1], groupId, directions);
        }
        
        return area;
    }
}
