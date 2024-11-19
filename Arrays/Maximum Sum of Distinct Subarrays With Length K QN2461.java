//https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/?envType=daily-question&envId=2024-11-19
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        HashSet<Integer> uniqueElements = new HashSet<>();
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];
            
            while (uniqueElements.contains(nums[end]) || uniqueElements.size() > k) {
                uniqueElements.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            
            uniqueElements.add(nums[end]);

            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                
                uniqueElements.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
        }

        return maxSum;
    }
}
