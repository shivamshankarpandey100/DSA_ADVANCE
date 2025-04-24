//https://leetcode.com/problems/count-complete-subarrays-in-an-array/

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums){
            unique.add(num);
        } 
        
        int totalDis = unique.size();
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(nums[j]);
                if (seen.size() == totalDis) {
                    count += n - j;
                    break;
                }
            }
        }

        return count;
    }
}