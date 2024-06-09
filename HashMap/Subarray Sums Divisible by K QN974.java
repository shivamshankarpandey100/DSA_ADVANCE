// https://leetcode.com/problems/subarray-sums-divisible-by-k

import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        
        remainderCount.put(0, 1);
        
        int cumulativeSum = 0;
        int count = 0;
        
        for (int num : nums) {
            cumulativeSum += num;
            
            int remainder = cumulativeSum % k;
            
            if (remainder < 0) {
                remainder += k;
            }
            
             if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }
            
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}
