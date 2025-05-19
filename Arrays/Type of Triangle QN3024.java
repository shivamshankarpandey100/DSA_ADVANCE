//https://leetcode.com/problems/type-of-triangle/

class Solution {
    public String triangleType(int[] nums) {
       if(nums[0]+nums[1]>nums[2] && nums[0]+nums[2]>nums[1] && nums[1]+nums[2]>nums[0] ){
            if(nums[0]==nums[1] ||  nums[0]==nums[2] || nums[1]==nums[2]){
                if(nums[1]==nums[2] && nums[2]==nums[0]){
                    return "equilateral";
                }
                else{
                    return "isosceles";
                }
            }
            return "scalene";
        }
        return "none";
    }
};