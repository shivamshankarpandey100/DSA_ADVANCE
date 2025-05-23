//https://leetcode.com/problems/find-the-maximum-sum-of-node-values

class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long baseSum = 0;
        List<Integer> gains = new ArrayList<>();
        
        for (int num : nums) {
            baseSum += num;
            int xored = num ^ k;
            gains.add(xored - num);
        }

        Collections.sort(gains, Collections.reverseOrder());

        long maxGain = 0;
        long currentGain = 0;

        for (int i = 0; i < gains.size(); i++) {
            currentGain += gains.get(i);
            if ((i + 1) % 2 == 0) {
                maxGain = Math.max(maxGain, currentGain);
            }
        }

        return baseSum + maxGain;
    }
}
