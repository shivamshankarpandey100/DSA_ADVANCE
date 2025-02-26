//https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;
        int currentMax = 0;
        int currentMin = 0;
        
        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num);
            currentMin = Math.min(currentMin + num, num);
            maxSum = Math.max(maxSum, currentMax);
            minSum = Math.min(minSum, currentMin);
        }
        
        return Math.max(maxSum, Math.abs(minSum));
    }
}
