//https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/

import java.util.HashSet;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int sum = 0; 
        int count = 0; 

        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }
            if (sum + i > maxSum) {
                break;
            }
            sum += i;
            count++;
        }

        return count; 
    }
}
