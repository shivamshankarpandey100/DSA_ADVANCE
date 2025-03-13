//https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

static int knapsack(int W, int val[], int wt[]) {
        int n=val.length;
        int dp[]=new int[W+1];
        for(int i=0;i<n;i++)
        {
            for(int j=W;j>=wt[i];j--)
            {
                dp[j]=Math.max(dp[j],val[i]+dp[j-wt[i]]);
            }
        }
        return dp[W];
    }

