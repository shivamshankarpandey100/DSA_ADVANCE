//https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1

class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        int n = arr.length;
        int max = arr[0];
        int min = arr[0];
        int res = arr[0];
        
        for(int i = 1 ; i < n ; i++) {
            int temp1 = arr[i];
            int temp2 = arr[i] * max;
            int temp3 = arr[i] * min;
            
            min = Math.min(temp1, Math.min(temp2, temp3));
            max = Math.max(temp1, Math.max(temp2, temp3));
            res = Math.max(res, Math.max(min, max));
        }
        return res;
    }
}