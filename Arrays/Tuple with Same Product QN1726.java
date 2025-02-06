//https://leetcode.com/problems/tuple-with-same-product

class Solution {
    public int tupleSameProduct(int[] nums) {
        
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int prod = nums[i] * nums[j];
                res += 8 * map.getOrDefault(prod, 0);

                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }

        return res;
    }
}