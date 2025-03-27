//https://leetcode.com/problems/minimum-index-of-a-valid-split/

class Solution {
    public int getDominantElement(List<Integer> nums){
        int dominant = nums.get(0);
        int freq     = 1;

        int i = 1;
        while(i<nums.size()){
            if(freq == 0){
                dominant = nums.get(i);
                freq = 1;
            }
            else if(nums.get(i) == dominant){
                freq++;
            }else{
                freq--;
            }
            i++;
        }
        return dominant;
    }

    public int getDominantFreq(List<Integer> nums, int dominant){
        int count = 0;
        for(int num: nums){
            if(num == dominant)
                count++;
        }
        return count;
    }

    public int minimumIndex(List<Integer> nums) {
        int size     = nums.size();
        int dominant = getDominantElement(nums);
        int freq     = getDominantFreq(nums,dominant);

        int count    = 0;

        for(int i = 0; i< size; i++){
            if(nums.get(i) == dominant)
                count++;
            int sizeOfSubArray1 = i+1;
            int sizeOfSubArray2 = size-i-1;

            if(count > sizeOfSubArray1/2 && freq-count > sizeOfSubArray2/2)
                return i;
        }
        return -1;
    }
}