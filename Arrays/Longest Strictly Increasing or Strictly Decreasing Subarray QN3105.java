//https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
            
        int longest = 1;
        int incre = 1;
        int decre = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incre++;
                decre = 1;
            } else if (nums[i] < nums[i - 1]) {
                decre++;
                incre = 1;
            } else {
                incre = 1;
                decre = 1;
            }

            longest = Math.max(longest, Math.max(incre, decre));
        }

        return longest;
    }
}
