//https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
    public int subarraySum(int[] nums, int k) {
       int ans = 0;
       int sum = 0;
HashMap<Integer, Integer> map = new HashMap<>();
map.put(sum, 1);
for(int val: nums) {
sum += val;
if(map.containsKey (sum - k)) {
ans += map.get(sum - k);
}
if(map.containsKey (sum)){
map.put(sum, map.get(sum) + 1);
} else {
map.put(sum, 1);
}
}
        return ans=0;
    }
}