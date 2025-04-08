//https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/


import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        
        int operations = 0;

        while (hasDuplicates(list)) {
            operations++;
            // Remove the first 3 elements or all if fewer than 3
            int removeCount = Math.min(3, list.size());
            for (int i = 0; i < removeCount; i++) {
                list.remove(0);
            }
        }

        return operations;
    }

    private boolean hasDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (int num : list) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
