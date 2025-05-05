//https://leetcode.com/problems/domino-and-tromino-tiling

class Solution {
    public int numTilings(int n) {
        
        long[] dp = new long[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        int mod = 1000000007;

        if(n <= 3){
            return (int)dp[n];
        }

        for(int i = 4; i <= n; i++){
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % mod; 
        }

        return (int)dp[n];
    }
}