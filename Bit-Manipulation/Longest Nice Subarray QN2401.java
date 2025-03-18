//https://leetcode.com/problems/longest-nice-subarray/

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, orMask = 0, maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            while ((orMask & nums[right]) != 0) {
                orMask ^= nums[left]; 
                left++;
            }
            
            orMask |= nums[right]; 
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
