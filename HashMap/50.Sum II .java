

//    https://leetcode.com/problems/4sum-ii/description/


import java.util.*;
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums1){
            for(int j : nums2){
                map.put(i + j, map.getOrDefault(i + j,  0) + 1);
            }
        }

        for(int k : nums3){
            for(int l : nums4){
                cnt += map.getOrDefault(-(k + l), 0);
            }
        }

        return cnt;
    }
}