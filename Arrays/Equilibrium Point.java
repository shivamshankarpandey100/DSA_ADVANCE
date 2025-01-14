//https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1

class Solution {
   public static int findEquilibrium(int arr[]) {
        int n=arr.length;
        int rightSum=0;
        for(int i=0;i<n;i++){
            rightSum+=arr[i];
        }
        int count=0;
        int leftSum=0;
        for(int i=0;i<n;i++){
            rightSum-=arr[i];
            if(i==0 && leftSum==rightSum){
                return i;
            }
            if(i==0) continue;
            leftSum+=arr[i-1];
            if(leftSum==rightSum){
                return i;
            }
            
        }
        return -1;
    }
}
