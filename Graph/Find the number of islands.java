//https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1

class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'L' && !visited[i][j]){
                    ans++;
                    dfs(i,j,grid,visited,n,m);
                }
            }
        }
        return ans;
    }
    public void dfs(int i , int j , char grid[][], boolean visited[][],int n , int m){
        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] ||grid[i][j] == 'W') return;
        
        visited[i][j] = true;
        
        dfs(i-1,j-1,grid,visited,n,m);
        dfs(i-1,j,grid,visited,n,m);
        dfs(i-1,j+1,grid,visited,n,m);
        dfs(i,j-1,grid,visited,n,m);
        dfs(i,j+1,grid,visited,n,m);
        dfs(i+1,j-1,grid,visited,n,m);
        dfs(i+1,j,grid,visited,n,m);
        dfs(i+1,j+1,grid,visited,n,m);
        
        
    }
}

