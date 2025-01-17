//https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        
       int[] res = new int[arr.length];
       int product = 1;
       boolean flag = false;
       int cnt0 = 0;
       
       for(int i=0; i<arr.length; i++){
           if(arr[i] == 0){
               cnt0++;
               flag = true;
               continue;
           }
           product *= arr[i];
       }
       
       if(cnt0 > 1) return res;
       
       for(int i=0; i<arr.length; i++){
           if(arr[i] != 0 && flag == true){
               res[i] = 0;
           }else if(arr[i] == 0 && flag == true){
               res[i] = product;
           }else{
               res[i] = product/arr[i]; 
           }
          
       }
       
       return res;
    }
}

