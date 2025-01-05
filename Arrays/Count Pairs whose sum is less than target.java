//https://www.geeksforgeeks.org/problems/count-pairs-whose-sum-is-less-than-target/1

class Solution {
    int countPairs(int arr[], int target) {
     
     
         Arrays.sort(arr);
         int tot = 0;
         int n = arr.length;
         
         
         for(int i=0;i<n;i++){
             int l = 0;
             int r = n-1;
             int ans = -1;
             
             while(l<=r){
                 int m = (l+r)>>1;
                 if(arr[m]+arr[i]>=target){
                     r = m -1 ;
                 }
                 else {
                     l = m + 1;
                     ans = m;
                 }
             }
             if(ans>=i){
                  ans--;
             }
             
             tot+=ans+1;
         }
         
         return tot/2;
    }
}