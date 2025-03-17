//https://leetcode.com/problems/divide-array-into-equal-pairs/

class Solution {
    public boolean divideArray(int[] nums) {
        int n=nums.length;
        int[] arr=new int[501];

        // Count frequencies of each number
        for(int i=0; i<n; i++){
            arr[nums[i]]++;
        }

        // Check if all frequencies are even
        for(int i=0; i<501; i++){
            if(arr[i]==0) continue;
            else if(arr[i]%2==1) return false;
        }

        return true;
    }
}