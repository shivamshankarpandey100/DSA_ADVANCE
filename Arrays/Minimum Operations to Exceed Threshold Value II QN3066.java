//https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int num : nums) {
            pq.add((long)num);
        }

        int cnt = 0;
        while (!pq.isEmpty() && pq.peek() < k) {
            long first = pq.poll();
            long second = pq.poll();
            cnt++;
            long val = (long)Math.min(first, second) * (long)2 + (long)Math.max(first, second);
            pq.add(val);
        }
        
        return cnt;
    }
}