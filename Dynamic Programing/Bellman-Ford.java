//https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

class Solution {
   public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist=new int[V];
        for(int i=0;i<V;i++) dist[i]=100000000;
        dist[src]=0;
        for(int i=0;i<V-1;i++){
            for(int[] edge:edges){
                int u=edge[0];
                int v=edge[1];
                int wt=edge[2];
                if(dist[u]!=100000000&&dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            if(dist[u]!=100000000&&dist[u]+wt<dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}
