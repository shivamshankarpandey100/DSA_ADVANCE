//https://www.geeksforgeeks.org/problems/min-cost-climbing-stairs/1

 int n=cost.length;
        for(int i=2;i<n;i++)cost[i]+=Math.min(cost[i-1],cost[i-2]);
        return Math.min(cost[n-1],cost[n-2]);