//https://www.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1

class Solution {

    public int circularSubarraySum(int arr[]) {
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int currMin=0;
        int currMax=0;
        int sum=0;
        
        
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        
        
        
        for(int i=0;i<arr.length;i++){
            currMin=currMin+arr[i];
            
            min=Math.min(currMin,min);
          
            
            if(currMin>0){
                currMin=0;
            }
            
        }
        
        
        for(int i=0;i<arr.length;i++){
            
            currMax=currMax+arr[i];
            max=Math.max(max,currMax);
            
            if(currMax<0){
                currMax=0;
            }
            
        }
        return Math.max(max,sum-min);

       
    }
}