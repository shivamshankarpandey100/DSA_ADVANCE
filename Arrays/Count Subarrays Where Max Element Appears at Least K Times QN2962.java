//https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = 0;

        for(int val : nums){
            if(val > max){
                max = val;
            }
        }

        int i = 0, j = 0;
        long ans = 0;
        int freq = 0;
        
        while (i < n && j < n) {
           
            if(nums[j] == max){
            freq++;
           }
           
            while (freq >= k) {
                ans += n - j;

                if(nums[i] == max){
                    freq--;
                }
                i++;
            }

            j++;
        }

        return ans;
    }
}