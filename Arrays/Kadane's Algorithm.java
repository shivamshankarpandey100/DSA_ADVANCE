//https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
class Solution {
    int maxSubarraySum(int[] arr) {
        int n =  arr.length;
        long maxsum = Integer.MIN_VALUE;
        long currsum = 0;
        
        for(int i = 0 ;i < n; i++)
        {
            currsum += arr[i];
            if(currsum < 0)
            {
                currsum = 0;
            }
            maxsum = Math.max(maxsum,currsum);
        }
        if(maxsum > 0)
        {
            return (int)maxsum;
        }
        else
        {
            Arrays.sort(arr);
            return arr[n-1];
        }
    }
}