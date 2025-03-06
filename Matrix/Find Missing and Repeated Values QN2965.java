//https://leetcode.com/problems/find-missing-and-repeated-values/

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;
        int[] count = new int[N + 1]; // 1 से N तक की गिनती रखने के लिए

        // ग्रिड में उपस्थित संख्याओं की गिनती करें
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }

        int repeated = -1, missing = -1;
        for (int i = 1; i <= N; i++) {
            if (count[i] == 2) {
                repeated = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeated, missing};
    }
}
