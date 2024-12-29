//https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

class Solution {
    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words[0].length();
        int MOD = (int) 1e9 + 7;
        int[][] freq = new int[26][n];

        for (String word : words) {
            for (int i = 0; i < n; i++) {
                freq[word.charAt(i) - 'a'][i]++;
            }
        }

        long[] dp = new long[m + 1];
        dp[0] = 1;
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                dp[i + 1] = (dp[i + 1] + dp[i] * freq[target.charAt(i) - 'a'][j]) % MOD;
            }
        }

        return (int) dp[m];
    }
}