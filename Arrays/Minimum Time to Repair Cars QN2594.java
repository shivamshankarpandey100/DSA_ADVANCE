//https://leetcode.com/problems/minimum-time-to-repair-cars/

import java.util.Arrays;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = (long) Arrays.stream(ranks).min().getAsInt() * (long) cars * cars; 
          long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canRepairInTime(ranks, cars, mid)) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canRepairInTime(int[] ranks, int cars, long maxTime) {
        long repairedCars = 0;
        for (int rank : ranks) {
            long count = (long) Math.sqrt(maxTime / rank); 
            repairedCars += count;
            if (repairedCars >= cars) return true;
        }
        return repairedCars >= cars;
    }
}
