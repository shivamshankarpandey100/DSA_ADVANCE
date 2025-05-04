//https://leetcode.com/problems/number-of-equivalent-domino-pairs/submissions/1625320232/
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100]; // Since 1 <= domino[i][j] <= 9, key will be in range 11 to 99
        int result = 0;

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            // Generate a key: always keep the smaller number first
            int key = a < b ? a * 10 + b : b * 10 + a;
            result += count[key];  // add how many same dominoes we've seen so far
            count[key]++;
        }

        return result;
    }
}
