//https://leetcode.com/problems/house-robber-iv/

class Solution {
    public int minCapability(int[] nums, int k) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        
        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, k, mid)) {
                high = mid;  
            } else {
                low = mid + 1; 
            }
        }

        return low;
    }

    private boolean isPossible(int[] nums, int k, int capability) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= capability) {
                count++;
                i++;  
            }
            if (count >= k) return true;
        }

        return false;
    }
}
